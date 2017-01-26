package com.ums.entities;

import com.ums.buildings.AdminBlock;
import com.ums.buildings.IBA;
import com.ums.buildings.Pharmacy;
import com.ums.buildings.UBIT;
import com.ums.lists.CourseList;
import com.ums.lists.StudentList;

import java.io.IOException;
import java.util.ArrayList;

public class Dean extends Employee implements Administrative, Faculty {

    public Dean() {
        super(null, null, null, null, null, 0, 0, Position.DEAN, 0);
    }

    public Dean(String id, String name, String qualification, String department, String password,
                int salary, int attendance, int port) {
        super(id, name, qualification, department, password, salary, attendance, Position.DEAN, port);
    }

    @Override
    public boolean hireNewEmployee(String name, String qualification, String department,
                                   int salary, Position position) throws IOException {

        return AdminBlock.registerEmployeeToFile("tr1" + String.valueOf(AdminBlock.employeeList.employees.size() + 5),
                name, qualification, this.department, "tr1" + String.valueOf(AdminBlock.employeeList.employees.size() + 5),
                salary, 0, Position.TEACHER, "20" + String.valueOf(AdminBlock.employeeList.employees.size() + 5));
    }

    @Override
    public boolean fireEmployee(String id) throws IOException {
        return AdminBlock.deleteEmployeeFromFile(id);
    }

    @Override
    public void organizeEvent(String name, int year, int month, int date, int hour, int minutes) {
        if (this.getDepartment() == "UBIT")
            UBIT.setEvent(name, year, month, date, hour, minutes);
        else if (this.getDepartment() == "IBA")
            IBA.setEvent(name, year, month, date, hour, minutes);
        else if (this.getDepartment() == "Pharmacy")
            Pharmacy.setEvent(name, year, month, date, hour, minutes);
    }

    @Override
    public String generateAttendanceReport() {
        String info = "";
        if (this.getDepartment().equals("UBIT")) {
            info += ("\n\n\t\t\tTeachers\n");
            for (int i = 0; i < UBIT.teacherList.size(); i++) {
                info += ("ID: " + UBIT.teacherList.get(i).getID()
                        + "\tName: " + UBIT.teacherList.get(i).getName()
                        + "\tAttendance: " + UBIT.teacherList.get(i).getAttendance() + "%" + "\n");
            }

            info += ("\n\n\t\t\tStudents\n");
            for (int i = 0; i < UBIT.studentList.students.size(); i++) {
                info += ("ID: " + UBIT.studentList.students.get(i).getID()
                        + "\tName: " + UBIT.studentList.students.get(i).getName()
                        + "\tAttendance: " + UBIT.studentList.students.get(i).getAttendance() + "%" + "\n");
            }

            return info;
        } else if (this.getDepartment().equals("IBA")) {
            info += ("\n\n\t\t\tTeachers\n");
            for (int i = 0; i < IBA.teacherList.size(); i++) {
                info += ("ID: " + IBA.teacherList.get(i).getID()
                        + "\tName: " + IBA.teacherList.get(i).getName()
                        + "\tAttendance: " + IBA.teacherList.get(i).getAttendance() + "%" + "\n");
            }

            info += ("\n\n\t\t\tStudents\n");
            for (int i = 0; i < IBA.studentList.students.size(); i++)
                info += ("ID: " + IBA.studentList.students.get(i).getID()
                        + "\tName: " + IBA.studentList.students.get(i).getName()
                        + "\tAttendance: " + IBA.studentList.students.get(i).getAttendance() + "%" + "\n");
            return info;
        } else {
            info += ("\n\n\t\t\tTeachers\n");
            for (int i = 0; i < Pharmacy.teacherList.size(); i++) {
                info += ("ID: " + Pharmacy.teacherList.get(i).getID()
                        + "\tName: " + Pharmacy.teacherList.get(i).getName()
                        + "\tAttendance: " + Pharmacy.teacherList.get(i).getAttendance() + "%" + "\n");
            }

            info += ("\n\n\t\t\tStudents\n");
            for (int i = 0; i < Pharmacy.studentList.students.size(); i++)
                info += ("ID: " + Pharmacy.studentList.students.get(i).getID()
                        + "\tName: " + Pharmacy.studentList.students.get(i).getName()
                        + "\tAttendance: " + Pharmacy.studentList.students.get(i).getAttendance() + "%" + "\n");
            return info;
        }
    }

    @Override
    public String generateSalaryReport() {
        String info = "";
        if (this.getDepartment().equals("UBIT")) {
            for (int i = 0; i < UBIT.teacherList.size(); i++) {
                info += ("ID: " + UBIT.teacherList.get(i).getID()
                        + "\tName: " + UBIT.teacherList.get(i).getName()
                        + "\tSalary: " + UBIT.teacherList.get(i).getSalary() + "\n");
            }

            return info;
        } else if (this.getDepartment().equals("IBA")) {
            for (int i = 0; i < IBA.teacherList.size(); i++) {
                info += ("ID: " + IBA.teacherList.get(i).getID()
                        + "\tName: " + IBA.teacherList.get(i).getName()
                        + "\tSalary: " + IBA.teacherList.get(i).getSalary() + "\n");
            }

            return info;
        } else {
            for (int i = 0; i < Pharmacy.teacherList.size(); i++) {
                info += ("ID: " + Pharmacy.teacherList.get(i).getID()
                        + "\tName: " + Pharmacy.teacherList.get(i).getName()
                        + "\tSalary: " + Pharmacy.teacherList.get(i).getSalary() + "\n");
            }

            return info;
        }
    }

    @Override
    public boolean suspendStudent(String id) throws IOException {
        return AdminBlock.deleteStudentFromFile(id);
    }

    @Override
    public boolean modifyCourse(String id, String name) throws IOException {
        return AdminBlock.modifyCourseInFile(id, name);
    }

    public boolean modifyCourse(String id, int creditHours) throws IOException {
        return AdminBlock.modifyCourseInFile(id, creditHours);
    }

    @Override
    public String generateResultReport() {

        String info = "";
        if (this.getDepartment().equals("UBIT")) {
            for (int i = 0; i < 20; i++) {
                info += ("\n\t\tName: " + UBIT.studentList.students.get(i).getName()
                        + "\n\t\tNo. of Subjects: 6\n"
                        + "\nIntroduction to Computer Science: " + UBIT.studentList.students.get(i).getMarks()[0]
                        + "\nIntroduction to Software Engineering: " + UBIT.studentList.students.get(i).getMarks()[1]
                        + "\nComputer Digital Organization and Logic Design: " + UBIT.studentList.students.get(i).getMarks()[2]
                        + "\nEnglish: " + UBIT.studentList.students.get(i).getMarks()[3]
                        + "\nIslamiat: " + UBIT.studentList.students.get(i).getMarks()[4]
                        + "\nCalculus: " + UBIT.studentList.students.get(i).getMarks()[5]
                        + "\n\t\t\tGPA: " + UBIT.studentList.students.get(i).getCGPA());
            }

            return info;
        } else if (this.getDepartment().equals("IBA")) {
            for (int i = 0; i < IBA.studentList.students.size(); i++) {
                info += ("\n\t\tName: " + IBA.studentList.students.get(i).getName()
                        + "\n\t\tNo. of Subjects: 6\n"
                        + "\nIntroduction to Accounting: " + IBA.studentList.students.get(i).getMarks()[0]
                        + "\nMicroeconomics: " + IBA.studentList.students.get(i).getMarks()[1]
                        + "\nIslamiat and Pakistan Studies/Humanities: " + IBA.studentList.students.get(i).getMarks()[2]
                        + "\nEnglish Writing Skills: " + IBA.studentList.students.get(i).getMarks()[3]
                        + "\nIT in Business: " + IBA.studentList.students.get(i).getMarks()[4]
                        + "\nFinancial Accounting: " + IBA.studentList.students.get(i).getMarks()[5]
                        + "\n\t\t\tGPA: " + IBA.studentList.students.get(i).getCGPA());
            }


            for (int i = 0; i < IBA.studentList.students.size(); i++) {
                info += ("\n\t\tName: " + IBA.studentList.students.get(i).getName()
                        + "\n\t\tNo. of Subjects: 6\n"
                        + "\nCalculus and Analytical Geometry: " + IBA.studentList.students.get(i).getMarks()[0]
                        + "\nPhysics-I: " + IBA.studentList.students.get(i).getMarks()[1]
                        + "\nEnglish Composition and Comprehension: " + IBA.studentList.students.get(i).getMarks()[2]
                        + "\nObject Oriented Programming: " + IBA.studentList.students.get(i).getMarks()[3]
                        + "\nTechnical and Business Writing: " + IBA.studentList.students.get(i).getMarks()[4]
                        + "\nStatistics and Probability: " + IBA.studentList.students.get(i).getMarks()[5]
                        + "\n\t\t\tGPA: " + IBA.studentList.students.get(i).getCGPA());
            }

            return info;
        } else {
            for (int i = 0; i < Pharmacy.studentList.students.size(); i++) {
                info += ("\n\t\tName: " + Pharmacy.studentList.students.get(i).getName()
                        + "\n\t\tNo. of Subjects: 6\n"
                        + "\nIslamic Idealogy-Pakistan Studies: " + Pharmacy.studentList.students.get(i).getMarks()[0]
                        + "\nPhysiology & Histology I: " + Pharmacy.studentList.students.get(i).getMarks()[1]
                        + "\nPhysiology & Histology II: " + Pharmacy.studentList.students.get(i).getMarks()[2]
                        + "\nPharmaceutical Biochemistry I: " + Pharmacy.studentList.students.get(i).getMarks()[3]
                        + "\nPharmaceutical Biochemistry II: " + Pharmacy.studentList.students.get(i).getMarks()[4]
                        + "\nPharmacology - Anatomy: " + Pharmacy.studentList.students.get(i).getMarks()[5]
                        + "\n\t\t\tGPA: " + Pharmacy.studentList.students.get(i).getCGPA());
            }
            return info;

        }
    }


    @Override
    public ArrayList<Teacher> getTeacherList() {
        if (this.getDepartment() == "UBIT")
            return UBIT.teacherList;
        else if (this.getDepartment() == "IBA")
            return IBA.teacherList;
        else
            return Pharmacy.teacherList;
    }

    @Override
    public StudentList getStudentList() {
        if (this.getDepartment() == "UBIT")
            return UBIT.studentList;
        else if (this.getDepartment() == "IBA")
            return IBA.studentList;
        else
            return Pharmacy.studentList;
    }

    @Override
    public CourseList getCourseList() {
        if (this.getDepartment() == "UBIT")
            return UBIT.courseList;
        else if (this.getDepartment() == "IBA")
            return IBA.courseList;
        else
            return Pharmacy.courseList;
    }

    @Override
    public String viewTeachers() {
        String info = "";
        if (this.getDepartment().equals("UBIT")) {
            for (int i = 0; i < UBIT.teacherList.size(); i++) {
                info += ("ID: " + UBIT.teacherList.get(i).getID()
                        + "\tName: " + UBIT.teacherList.get(i).getName()
                        + "\tQualification: " + UBIT.teacherList.get(i).getQualification() + "\n");
            }

            return info;
        } else if (this.getDepartment().equals("IBA")) {
            for (int i = 0; i < IBA.teacherList.size(); i++) {
                info += ("ID: " + IBA.teacherList.get(i).getID()
                        + "\tName: " + IBA.teacherList.get(i).getName()
                        + "\tQualification: " + IBA.teacherList.get(i).getQualification() + "\n");
            }

            return info;
        } else {
            for (int i = 0; i < Pharmacy.teacherList.size(); i++)
                info += ("ID: " + Pharmacy.teacherList.get(i).getID()
                        + "\tName: " + Pharmacy.teacherList.get(i).getName()
                        + "\tQualification: " + Pharmacy.teacherList.get(i).getQualification() + "\n");

            return info;
        }
    }

    @Override
    public String viewStudents() {
        String info = "";
        if (this.getDepartment().equals("UBIT")) {
            for (int i = 0; i < UBIT.studentList.students.size(); i++) {
                info += ("ID: " + UBIT.studentList.students.get(i).getID()
                        + "\tName: " + UBIT.studentList.students.get(i).getName()
                        + "\tSemester: " + UBIT.studentList.students.get(i).getSemester()
                        + "\tField: " + UBIT.studentList.students.get(i).getField() + "\n");
            }

            return info;
        } else if (this.getDepartment().equals("IBA")) {
            for (int i = 0; i < IBA.studentList.students.size(); i++) {
                info += ("ID: " + IBA.studentList.students.get(i).getID()
                        + "\tName: " + IBA.studentList.students.get(i).getName()
                        + "\tSemester: " + IBA.studentList.students.get(i).getSemester()
                        + "\tField: " + IBA.studentList.students.get(i).getField() + "\n");
            }

            return info;
        } else {
            for (int i = 0; i < Pharmacy.studentList.students.size(); i++) {
                info += ("ID: " + Pharmacy.studentList.students.get(i).getID()
                        + "\tName: " + Pharmacy.studentList.students.get(i).getName()
                        + "\tSemester: " + Pharmacy.studentList.students.get(i).getSemester()
                        + "\tField: " + Pharmacy.studentList.students.get(i).getField() + "\n");
            }
            return info;
        }
    }

    @Override
    public void increaseSalary(String id, int salary) throws IOException {
        if (this.department.equals("UBIT")) {
            for (int i = 0; i < UBIT.teacherList.size(); i++) {
                if (UBIT.teacherList.get(i).equals(id))
                    UBIT.teacherList.get(i).setSalary(salary);
            }

            AdminBlock.writeToAllFiles();
            AdminBlock.readFromAllFiles();
        } else if (this.department.equals("IBA")) {
            for (int i = 0; i < IBA.teacherList.size(); i++) {
                if (IBA.teacherList.get(i).equals(id))
                    IBA.teacherList.get(i).setSalary(salary);
            }

            AdminBlock.writeToAllFiles();
            AdminBlock.readFromAllFiles();
        } else if (this.department.equals("UBIT")) {
            for (int i = 0; i < Pharmacy.teacherList.size(); i++) {
                if (Pharmacy.teacherList.get(i).equals(id))
                    Pharmacy.teacherList.get(i).setSalary(salary);
            }

            AdminBlock.writeToAllFiles();
            AdminBlock.readFromAllFiles();
        }
    }

    @Override
    public String viewCourses() {
        String info = "";
        if (this.getDepartment().equals("UBIT")) {
            for (int i = 0; i < UBIT.courseList.courses.size(); i++) {
                info += ("ID: " + UBIT.courseList.courses.get(i).getID()
                        + "\tName: " + UBIT.courseList.courses.get(i).getName()
                        + "\tCredit hours: " + UBIT.courseList.courses.get(i).getCreditHours()
                        + "\tField: " + UBIT.courseList.courses.get(i).getField() + "\n");
            }

            return info;
        } else if (this.getDepartment().equals("IBA")) {
            for (int i = 0; i < IBA.courseList.courses.size(); i++) {
                info += ("ID: " + IBA.courseList.courses.get(i).getID()
                        + "\tName: " + IBA.courseList.courses.get(i).getName()
                        + "\tCredit hours: " + IBA.courseList.courses.get(i).getCreditHours()
                        + "\tField: " + IBA.courseList.courses.get(i).getField() + "\n");
            }

            return info;
        } else {
            for (int i = 0; i < Pharmacy.courseList.courses.size(); i++) {
                info += ("ID: " + Pharmacy.courseList.courses.get(i).getID()
                        + "\tName: " + Pharmacy.courseList.courses.get(i).getName()
                        + "\tCredit hours: " + Pharmacy.courseList.courses.get(i).getCreditHours()
                        + "\tField: " + Pharmacy.courseList.courses.get(i).getField() + "\n");
            }

            return info;
        }
    }

    @Override
    public void requestIncreaseInSalary() {

    }

    public boolean getVCAuthorization() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void registerStudent(String name, String department, String field) throws IOException {
        AdminBlock.registerStudentToFile("st1" + String.valueOf(AdminBlock.studentList.students.size() + 5),
                name, department, field, "st1" + String.valueOf(AdminBlock.studentList.students.size() + 5),
                0, 0, 0, 0, "10" + String.valueOf(AdminBlock.studentList.students.size() + 5));
    }

    public boolean login(String id, String password) {
        for (int i = 0; i < AdminBlock.deanList.size(); i++) {
            if ((AdminBlock.deanList.get(i).getID().equalsIgnoreCase(id))
                    && ((AdminBlock.deanList.get(i).getPassword().equals(password))))
                return true;
        }
        return false;
    }

    @Override
    public void changePassword(String pass) throws IOException {
        for (int i = 0; i < AdminBlock.deanList.size(); i++) {
            if (AdminBlock.deanList.get(i).getID().equalsIgnoreCase(this.getID())) {
                AdminBlock.deanList.get(i).setPassword(pass);
                AdminBlock.writeToAllFiles();
            }
        }
    }
}