/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pets;

import java.time.LocalDateTime;

/**
 *
 * @author Professor Wergeles
 */
public interface RegisteredPet {
    Boolean isRegistered();
    void assignRegistration();
    LocalDateTime whenRegistered();
}