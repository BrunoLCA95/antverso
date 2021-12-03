package com.BrunoLCA95.antverso.service;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import com.BrunoLCA95.antverso.commons.WebExeption;
import com.BrunoLCA95.antverso.commons.roles;
import com.BrunoLCA95.antverso.entity.Usuario;
import com.BrunoLCA95.antverso.repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.sonatype.restsimple.client.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UsuarioService implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })
    public Usuario save(Usuario user) throws WebExeption{
        validation(user);
        Usuario user_save = new Usuario();
        user_save.setNombre(user.getNombre());
        user_save.setContraseña(new BCryptPasswordEncoder().encode(user.getContraseña()));
        user_save.setRol(roles.ADMIN);
        return usuarioRepository.save(user_save);

    }

    public void validation(Usuario user) throws WebExeption{

        if (user.getNombre() == null || user.getNombre().isEmpty() || user.getNombre().contains(" ")) {
            throw new WebExeption("Debe tener un Nombre de usuario valido");          
        }

        if (usuarioRepository.findByNombre(user.getNombre()) != null) {
            throw new WebExeption("El usuario ya se encuentra registrado");
        }

        if (user.getContraseña().length() <= 7) {
            throw new WebExeption("La clave es muy corta");
        }

        if (usuarioRepository.findByEmail(user.getEmail()) != null) {
            throw new WebExeption("El correo ya se encuentra registrado");
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {        
        Usuario user = usuarioRepository.findByNombre(username);

        if (user != null) {
            List<GrantedAuthority> permissions = new ArrayList<>();
            
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + user.getRol().toString());
            permissions.add(p);
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuario", user);
            return new org.springframework.security.core.userdetails.User(user.getNombre(), user.getContraseña(),permissions);
        }

        return null;
    }
    

    

}
