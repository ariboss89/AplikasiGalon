/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

/**
 *
 * @author User
 */
public class tb_admin {
    public static String username;
    public static String role;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        tb_admin.username = username;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        tb_admin.role = role;
    }
}
