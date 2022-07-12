/**
 * @author :  Dinuth Dheeraka
 * Project :  Database-Programming
 * Created : 7/12/2022 10:07 AM
 */
package view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentTM {

    private String studentId;
    private String name;
    private String email;
    private String contact;
    private String address;
    private String nic;
}
