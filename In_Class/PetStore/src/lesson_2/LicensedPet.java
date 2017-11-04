/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson_2;

import java.time.LocalDateTime;

/**
 *
 * @author WIN
 */
public interface LicensedPet {
    void assignedLicense();
    Boolean isLicensed();
    LocalDateTime whenLicensed();
    
}
