package com.org.jsf.dao;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.org.jsf.domain.User;

public class UserDao {
	/**
	   * Método utilizado para obter o entity manager.
	   * @return
	   */
	
	@Produces
	@PersistenceContext(name="jsfPU")
    private EntityManager entityManager;
	
	  private EntityManager getEntityManager() {
		  return entityManager;
	  }

	  /**
	   * Método utilizado para salvar ou atualizar as informações de um usuario.
	   * @param user
	   * @return
	   * @throws java.lang.Exception
	   */
	  public User salvar(User user) throws Exception {
	    EntityManager entityManager = getEntityManager();
	    try {
	      // Inicia uma transação com o banco de dados.
	      entityManager.getTransaction().begin();
	      System.out.println("Salvando o Usuário.");
	      // Verifica se a pessoa ainda não está salva no banco de dados.
	      
	      if(user.getId() == 0) {
	        //Salva os dados de um usuario.
	        entityManager.persist(user);
	      } else {
	        //Atualiza os dados do usuário.
	        user = entityManager.merge(user);
	      }
	      // Finaliza a transação.
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	    return user;
	  }

	  /**
	   * Método que apaga um Usuário do banco de dados.
	   * @param id
	   */
	  public void excluir(Long id) {
	    EntityManager entityManager = getEntityManager();
	    try {
	      // Inicia uma transação com o banco de dados.
	      entityManager.getTransaction().begin();
	      // Consulta um usuário na base de dados através do seu ID.
	      User user = entityManager.find(User.class, id);
	      System.out.println("Excluindo os dados de: " + user.getName());
	      // Remove a user da base de dados.
	      entityManager.remove(user);
	      // Finaliza a transação.
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	  }

	  /**
	   * Consulta o usuario pelo ID.
	   * @param id
	   * @return o objeto User.
	   */
	  public User consultarPorId(Long id) {
	    EntityManager entityManager = getEntityManager();
	    User user = null;
	    try {
	      //Consulta uma usuario pelo seu ID.
	      user = entityManager.find(User.class, id);
	    } finally {
	      entityManager.close();
	    }
	    return user;
	  }
}
