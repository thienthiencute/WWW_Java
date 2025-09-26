package bai01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/student")
@MultipartConfig
public class StudentServlet extends HttpServlet {
    public StudentServlet () {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dateOfBirthStr = req.getParameter("dateOfBirth");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("mobile");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String pinCode = req.getParameter("pinCode");
        String state = req.getParameter("state");
        String country = req.getParameter("country");
        String[] hobbies = req.getParameterValues("hobbies");


        LocalDate dateOfBirth = null;
        if (dateOfBirthStr != null && !dateOfBirthStr.isEmpty()) {
            dateOfBirth = LocalDate.parse(dateOfBirthStr);
        }
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDateOfBirth(dateOfBirth);
        student.setGender(gender);
        student.setEmail(email);
        student.setPhoneNumber(phoneNumber);
        student.setAddress(address);
        student.setCity(city);
        student.setPinCode(pinCode);
        student.setState(state);
        student.setCountry(country);
        student.setHobbies(hobbies);
        System.out.println("Hobbies: " + Arrays.toString(hobbies));

        req.setAttribute("student", student);


        req.getRequestDispatcher("/student_info.jsp").forward(req, resp);
    }


}
