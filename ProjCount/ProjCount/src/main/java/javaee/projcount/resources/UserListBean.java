/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package javaee.projcount.resources;


import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class UserListBean {
    private final ConcurrentHashMap<String, String> activeUsers = new ConcurrentHashMap<>();

    public synchronized void addUser(String sessionId, String username) {
        activeUsers.put(sessionId, username);
    }

    public synchronized void removeUser(String sessionId) {
        activeUsers.remove(sessionId);
    }

    public List<String> getUsernames() {
        return new ArrayList<>(activeUsers.values());
    }

    public int getUserCount() {
        return activeUsers.size();
    }
}
