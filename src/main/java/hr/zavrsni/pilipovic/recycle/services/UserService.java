package hr.zavrsni.pilipovic.recycle.services;

import hr.zavrsni.pilipovic.recycle.entities.Authority;
import hr.zavrsni.pilipovic.recycle.entities.User;
import hr.zavrsni.pilipovic.recycle.entities.UserCommand;
import hr.zavrsni.pilipovic.recycle.entities.UserDTO;
import hr.zavrsni.pilipovic.recycle.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService  {


    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public Optional<UserDTO> editUser(User editedUser) {

        User user = new User();

        user.setId(editedUser.getId());
        user.setFirstname(editedUser.getFirstname());
        user.setLastname(editedUser.getLastname());
        user.setAddress(editedUser.getAddress());
        user.setEmail(editedUser.getEmail());
        user.setUsername(editedUser.getUsername());

        if(editedUser.getPassword() !="" && user.getPassword() != bCryptPasswordEncoder.encode(editedUser.getPassword()))
        {
            user.setPassword(bCryptPasswordEncoder.encode(editedUser.getPassword()));
        }  
      
        return Optional.of(mapToUserDTO(userRepository.save(user)));
    }


    private UserDTO mapToUserDTO(final User user)
    {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setUsername(user.getUsername());
        userDTO.setAuthorities(user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));
        userDTO.setEmail(user.getEmail());
        userDTO.setAddress(user.getAddress());
        userDTO.setUser_recycle(user.getRecycles());

        System.out.println(userDTO.toString());

        return userDTO;
    }

    public Optional<UserDTO> findByUsername(String username)
    {
        return Optional.of(mapToUserDTO(userRepository.findByUsername(username)));
    }

    public Optional<UserDTO> addUser(UserCommand user)
    {
        return Optional.of(mapToUserDTO(userRepository.save(user)));
    }

}