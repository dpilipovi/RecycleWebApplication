package hr.zavrsni.pilipovic.recycle.services;

import hr.zavrsni.pilipovic.recycle.entities.Authority;
import hr.zavrsni.pilipovic.recycle.entities.User;
import hr.zavrsni.pilipovic.recycle.entities.UserCommand;
import hr.zavrsni.pilipovic.recycle.entities.UserDTO;
import hr.zavrsni.pilipovic.recycle.repositories.AuthorityRepository;
import hr.zavrsni.pilipovic.recycle.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository)
    {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }


    public Optional<UserDTO> editUser(UserCommand editedUser) {

        Optional<User> optional = userRepository.findById(editedUser.getId());

        User user = optional.get();

        user.setFirstname(editedUser.getFirstname());
        user.setLastname(editedUser.getLastname());
        user.setAddress(editedUser.getAddress());
        user.setEmail(editedUser.getEmail());
        user.setUsername(editedUser.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(editedUser.getPassword()));


        return Optional.of(mapToUserDTO(userRepository.save(user)));
    }


    public Optional<UserDTO> findByUsername(String username)
    {
       // System.out.println("username = "+username);
        return userRepository.findByUsername(username).map(this::mapToUserDTO);
    }


    public Optional<UserDTO> addUser(UserCommand userCommand)
    {
        Set<Authority> set = new HashSet<>();
        Authority role_user = authorityRepository.findByName("ROLE_USER");
        set.add(role_user);
        User user = new User(userCommand.getFirstname(),userCommand.getLastname(),userCommand.getUsername(),userCommand.getAddress(),bCryptPasswordEncoder.encode(userCommand.getPassword()),userCommand.getEmail());
        user.setAuthorities(set);

        return Optional.of(mapToUserDTO(userRepository.save(user)));
    }

    @Override
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::mapToUserDTO).collect(Collectors.toList());
    }


    private UserDTO mapToUserDTO(final User user)
    {
        UserDTO userDTO = new UserDTO();

      /*  System.out.println("mapiranje");
        System.out.println(user.toString());*/

        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setUsername(user.getUsername());
        if(user.getAuthorities() != null) userDTO.setAuthorities(user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));
        userDTO.setEmail(user.getEmail());
        userDTO.setAddress(user.getAddress());
        if(user.getRecycles() != null)  userDTO.setUser_recycle(user.getRecycles());

        //System.out.println(userDTO.toString());

        return userDTO;
    }

}