package com.carvajal.ebusiness.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.carvajal.ebusiness.dao.ClientDAO;
import com.carvajal.ebusiness.dto.ClientDTO;
import com.carvajal.ebusiness.mapper.RolMapper;
import com.carvajal.ebusiness.model.Client;
import com.carvajal.ebusiness.model.Rol;
import com.carvajal.ebusiness.security.Security;
import com.carvajal.ebusiness.service.ClientService;
import com.carvajal.ebusiness.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("clientServiceImpl")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO cliDAO;

    @Autowired
    @Qualifier("rolServiceImpl")
    private RolService rService;

    private Security security;

    public Client clientDefault(){
        //Set<Rol> rolClient = new HashSet<>();
        //rService = new RolServiceImpl();
        //Convert from RolDTO to ROL
        Rol rClient = RolMapper.rolDtoToRol(rService.addRol("ROL_CLIENT"));
        //Rol rClient = new Rol();
        //rClient.setName("ROL_CLIENT");
        //rolClient.add(rClient);
        Client cli1 = new Client(1569874620, "carlos", "postgres",security.passwordEncoder().encode("123"));
        cli1.addRol(rClient);
        return cli1;
    }

    @Override
    public Optional<Client> addClient(Client client) {
        if(Optional.of(client).isPresent()){
            Client aux = cliDAO.save(client);
            return Optional.of(aux);
        }
        else{
            return Optional.empty();
        }
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clientList = (List<Client>)cliDAO.findAll();
        List<ClientDTO> clientDTO = new ArrayList<>();
        clientList.forEach(cli->{
            clientDTO.add(new ClientDTO(
                cli.getDocument(), 
                cli.getName(), 
                cli.getUsername(),
                cli.getPassword()
            ));
        });

        return clientDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> client = cliDAO.findByUsername(username);
        if (client.isEmpty()) {
            throw new UsernameNotFoundException("Usuario o contraseña inválidos");
        }
        return new User(client.get().getName(), client.get().getPassword(), mapAuthoritiesRoles(client.get().getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapAuthoritiesRoles(Collection<Rol> roles){
        return roles.stream()
            .map(r -> new SimpleGrantedAuthority(r.getName()))
            .collect(Collectors.toList()
        );
    }
}
