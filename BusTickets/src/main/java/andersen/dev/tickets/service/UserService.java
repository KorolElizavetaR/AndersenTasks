package andersen.dev.tickets.service;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import andersen.dev.tickets.aspect.annotation.EnableDML;
import andersen.dev.tickets.dto.UserDTO;
import andersen.dev.tickets.mapper.UserMapper;
import andersen.dev.tickets.model.User;
import andersen.dev.tickets.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@EnableDML
	@Transactional(readOnly = false)
	public User addUser(User user) {
		return userRepository.addUser(user);
	}

	public Set<User> getUserByIdWithTickets(int id) {
		return userRepository.getUserByIdWithTickets(id);
	}

	public UserDTO getUserByIdWithoutTickets(int id) {
		return userMapper.getUserDTO(userRepository.getUserByIdWithoutTickets(id));
	}

	@EnableDML
	@Transactional(readOnly = false)
	public void deleteUser(int id) {
		userRepository.deleteUser(id);
	}
}
