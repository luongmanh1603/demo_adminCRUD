package com.example.demo_admincrud.controller;

import com.example.demo_admincrud.entity.ClassRoom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "classRoomController", value = "/classrooms")
public class ClassRoomController  extends HttpServlet {
private EntityManagerFactory entityManagerFactory;
private EntityManager entityManager;

public void init() {
entityManagerFactory = Persistence.createEntityManagerFactory("default");
entityManager = entityManagerFactory.createEntityManager();
}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   var classRooms = entityManager.createQuery("SELECT c FROM ClassRoom c", ClassRoom.class).getResultList();
req.setAttribute("classRooms", classRooms);
req.getRequestDispatcher("views/pages/class.jsp").forward(req, resp);
    }

    public void destroy() {
    super.destroy();
}

}
