import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GUI implements java.awt.event.ActionListener {
    int x = 0;

    JFrame frame;
    JPanel panel;
    JTextField username;
    JPasswordField password;
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension size = toolkit.getScreenSize();
    JLabel label;
    JLabel label2;
    JButton login;
    JButton signup;
    JLabel success;
    JButton create;
    JTextField name;
    JTextField lastName;
    JButton infoChange;
    JButton appView;
    JButton register;
    JButton schedapp;
    JButton appoint;
    JButton updat;
    JButton addInf;
    JButton confirm;
    JTextField user;
    JTextField pass;
    JTextField newName;
    JTextField lastname;
    JTextField gender;
    JTextField ssn;
    JTextField telephone;
    JTextField birthday;
    JTextField age;
    JTextField adresse;
    JTextField postalCode;
    JTextField province;
    JTextField town;
    JTextField email;
    JTextField assurance;
    JTextField branch;
    JTextField parentName;
    JTextField parentLastName;
    JTextField relationship;
    JTextField succ;
    JTextField patientLastName;
    JTextField patientName;
    JTextField dentistLastName;
    JTextField dentistName;
    JTextField hygLastName;
    JTextField hygName;
    JTextField rvdate;
    JTextField startTime;
    JTextField endTime;
    JTextField rvType;
    JTextField status;
    JTextField room;
    JTextField procedure;
    JTextField treatment;

    public GUI() {

        frame = new JFrame();
        panel = new JPanel();
        login = new JButton("login");

        panel.setPreferredSize(new Dimension(300, 150));
        frame.setLocation((int) size.getWidth() / 2 - 150, (int) size.getHeight() / 2 - 75);

        panel.setLayout(null);

        loginButton();

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("test");
        frame.pack();
        frame.setVisible(true);

    }

    public void start() {

        label = new JLabel("name");
        label.setBounds(20, 20, 80, 25);
        label2 = new JLabel("last name");
        label2.setBounds(20, 50, 80, 25);
        JLabel label3 = new JLabel("password");
        label3.setBounds(20, 80, 80, 25);
        success = new JLabel("");
        success.setBounds(50, 110, 200, 25);
        name = new JTextField();
        name.setBounds(100, 20, 165, 25);
        lastName = new JTextField();
        lastName.setBounds(100, 50, 165, 25);
        password = new JPasswordField();
        password.setBounds(100, 80, 165, 25);

        login.setBounds(113, 110, 75, 25);

        panel.add(success);
        panel.add(login);
        panel.add(name);
        panel.add(lastName);
        panel.add(password);
        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        panel.revalidate();
        panel.repaint();
    }

    public void modAcc() {
        ArrayList<JTextField> info = new ArrayList<JTextField>();
        panel.setLayout(null);
        frame.setBounds((int) size.getWidth() / 2 - 150, (int) size.getHeight() / 2 - 325, 300, 650);
        JLabel regi = new JLabel("Register");
        regi.setBounds(115, 10, 300, 30);
        panel.add(regi);
        create = new JButton("create account");
        create.setBounds(70, 550, 160, 40);
        panel.add(create);
        user = new JTextField();
        pass = new JTextField();
        name = new JTextField();
        lastname = new JTextField();
        gender = new JTextField();
        ssn = new JTextField();
        telephone = new JTextField();
        birthday = new JTextField();
        age = new JTextField();
        adresse = new JTextField();
        postalCode = new JTextField();
        province = new JTextField();
        town = new JTextField();
        email = new JTextField();
        assurance = new JTextField();
        branch = new JTextField();
        info.add(user);
        info.add(pass);
        info.add(name);
        info.add(lastname);
        info.add(gender);
        info.add(ssn);
        info.add(telephone);
        info.add(birthday);
        info.add(age);
        info.add(adresse);
        info.add(postalCode);
        info.add(province);
        info.add(town);
        info.add(email);
        info.add(assurance);
        info.add(branch);

        ArrayList<JLabel> infolabel = new ArrayList<JLabel>();
        infolabel.add(new JLabel("username"));
        infolabel.add(new JLabel("password"));
        infolabel.add(new JLabel("name"));
        infolabel.add(new JLabel("lastname"));
        infolabel.add(new JLabel("gender"));
        infolabel.add(new JLabel("ssn"));
        infolabel.add(new JLabel("telephone"));
        infolabel.add(new JLabel("birthday"));
        infolabel.add(new JLabel("age"));
        infolabel.add(new JLabel("adresse"));
        infolabel.add(new JLabel("postalCode"));
        infolabel.add(new JLabel("province"));
        infolabel.add(new JLabel("town"));
        infolabel.add(new JLabel("email"));
        infolabel.add(new JLabel("assurance"));
        infolabel.add(new JLabel("branch"));
        createAccount();
        int a = 50;
        for (JTextField i : info) {
            i.setBounds(100, a, 165, 25);
            a = a + 30;
            panel.add(i);
        }
        a = 50;
        for (JLabel i : infolabel) {
            i.setBounds(20, a, 70, 25);
            a = a + 30;
            panel.add(i);
        }

    }

    public void register() {
        ArrayList<JTextField> info = new ArrayList<JTextField>();
        panel.setLayout(null);
        frame.setBounds((int) size.getWidth() / 2 - 150, (int) size.getHeight() / 2 - 325, 300, 650);
        JLabel regi = new JLabel("Register");
        regi.setBounds(115, 10, 300, 30);
        panel.add(regi);
        create = new JButton("create account");
        create.setBounds(70, 550, 160, 40);
        panel.add(create);
        user = new JTextField();
        pass = new JTextField();
        name = new JTextField();
        lastname = new JTextField();
        gender = new JTextField();
        ssn = new JTextField();
        telephone = new JTextField();
        birthday = new JTextField();
        age = new JTextField();
        adresse = new JTextField();
        postalCode = new JTextField();
        province = new JTextField();
        town = new JTextField();
        email = new JTextField();
        assurance = new JTextField();
        branch = new JTextField();
        info.add(user);
        info.add(pass);
        info.add(name);
        info.add(lastname);
        info.add(gender);
        info.add(ssn);
        info.add(telephone);
        info.add(birthday);
        info.add(age);
        info.add(adresse);
        info.add(postalCode);
        info.add(province);
        info.add(town);
        info.add(email);
        info.add(assurance);
        info.add(branch);

        ArrayList<JLabel> infolabel = new ArrayList<JLabel>();
        infolabel.add(new JLabel("username"));
        infolabel.add(new JLabel("password"));
        infolabel.add(new JLabel("name"));
        infolabel.add(new JLabel("lastname"));
        infolabel.add(new JLabel("gender"));
        infolabel.add(new JLabel("ssn"));
        infolabel.add(new JLabel("telephone"));
        infolabel.add(new JLabel("birthday"));
        infolabel.add(new JLabel("age"));
        infolabel.add(new JLabel("adresse"));
        infolabel.add(new JLabel("postalCode"));
        infolabel.add(new JLabel("province"));
        infolabel.add(new JLabel("town"));
        infolabel.add(new JLabel("email"));
        infolabel.add(new JLabel("assurance"));
        infolabel.add(new JLabel("branch"));
        modifyAccount();
        int a = 50;
        for (JTextField i : info) {
            i.setBounds(100, a, 165, 25);
            a = a + 30;
            panel.add(i);
        }
        a = 50;
        for (JLabel i : infolabel) {
            i.setBounds(20, a, 70, 25);
            a = a + 30;
            panel.add(i);
        }

    }

    public void admin() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(new JButton("add employee"));
        panel.add(new JButton("view employees"));
        panel.add(new JButton("view patients"));

    }

    public void patientLogin() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        infoChange = new JButton("change info");
        appView = new JButton("view appointments");
        viewApp();
        viewAccount();

        panel.add(infoChange);
        panel.add(appView);
        // need: change info

    }

    public void employeeLogin() {
        // change info
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        infoChange = new JButton("change info");
        appView = new JButton("view appointments");
        register = new JButton("add a patient");
        appoint = new JButton("schedule appointment");
        viewApp();
        viewAccount();
        registerButton();
        appointAdd();
        panel.add(appoint);
        panel.add(register);
        panel.add(infoChange);
        panel.add(appView);
    }

    public void addAppoint() {
        ArrayList<JTextField> info = new ArrayList<JTextField>();
        panel.setLayout(null);
        frame.setBounds((int) size.getWidth() / 2 - 150, (int) size.getHeight() / 2 - 325, 300, 650);
        JLabel regi = new JLabel("appointment");
        regi.setBounds(115, 10, 300, 30);
        panel.add(regi);
        schedapp = new JButton("create rv");
        schedapp.setBounds(70, 550, 160, 40);
        panel.add(schedapp);
        succ = new JTextField();
        patientLastName = new JTextField();
        patientName = new JTextField();
        dentistLastName = new JTextField();
        dentistName = new JTextField();
        hygLastName = new JTextField();
        hygName = new JTextField();
        rvdate = new JTextField();
        startTime = new JTextField();
        endTime = new JTextField();
        rvType = new JTextField();
        status = new JTextField();
        room = new JTextField();
        procedure = new JTextField();
        treatment = new JTextField();

        info.add(succ);
        info.add(patientLastName);
        info.add(patientName);
        info.add(dentistLastName);
        info.add(dentistName);
        info.add(hygLastName);
        info.add(hygName);
        info.add(rvdate);
        info.add(startTime);
        info.add(endTime);
        info.add(rvType);
        info.add(status);
        info.add(room);
        info.add(procedure);
        info.add(treatment);

        ArrayList<JLabel> infolabel = new ArrayList<JLabel>();
        infolabel.add(new JLabel("succ"));
        infolabel.add(new JLabel("patient last name"));
        infolabel.add(new JLabel("patient name"));
        infolabel.add(new JLabel("dentist lastname"));
        infolabel.add(new JLabel("dentist name"));
        infolabel.add(new JLabel("hygienist last name"));
        infolabel.add(new JLabel("hygienist name"));
        infolabel.add(new JLabel("rv date"));
        infolabel.add(new JLabel("start time"));
        infolabel.add(new JLabel("end time"));
        infolabel.add(new JLabel("rv type"));
        infolabel.add(new JLabel("status"));
        infolabel.add(new JLabel("room"));
        infolabel.add(new JLabel("procedure"));
        infolabel.add(new JLabel("treatment"));


        addApp();

        int a = 50;
        for (JTextField i : info) {

            i.setBounds(100, a, 165, 25);
            a = a + 30;
            panel.add(i);
        }
        a = 50;
        for (JLabel i : infolabel) {
            i.setBounds(20, a, 70, 25);
            a = a + 30;
            panel.add(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // ---------------------------------------------------------------------------------------------------------------
    // list of buttons
    public void loginButton() {
        ActionListener buttlog = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent v) {
                String user = name.getText();
                String lastUser = lastName.getText();
                String pass = password.getText();
                if (user.equals("a") && lastUser.equals("a") && pass.equals("a")) {
                    panel.removeAll();
                    admin();
                    panel.revalidate();
                    panel.repaint();
                } else
                    try {

                        if (DbFunctions.check(lastUser, user, pass)) {

                            if (DbFunctions.isEmployee(DbFunctions.getUserid(lastUser, user))) {
                                panel.removeAll();
                                employeeLogin();
                                panel.revalidate();
                                panel.repaint();
                            } else if (DbFunctions.isPatient(DbFunctions.getUserid(lastUser, user))) {
                                panel.removeAll();
                                patientLogin();
                                panel.revalidate();
                                panel.repaint();
                            }
                        } else {
                            success.setText("incorrect login attempt");
                        }
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }
            }
        };
        login.addActionListener(buttlog);
    }

    public void registerButton() {
        ActionListener buttreg = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent x) {
                panel.removeAll();
                register();
                panel.revalidate();
                panel.repaint();
            }
        };
        register.addActionListener(buttreg);
    }

    public void createAccount() {
        ActionListener accountCreation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (Integer.parseInt(age.getText()) < 16) {
                    panel.removeAll();
                    frame.setBounds((int) size.getWidth() / 2 - 200, (int) size.getHeight() / 2 - 75, 400, 250);
                    label = new JLabel("parent last name");
                    label.setBounds(20, 20, 120, 25);
                    label2 = new JLabel("parent name");
                    label2.setBounds(20, 50, 80, 25);
                    JLabel label3 = new JLabel("relationship");
                    label3.setBounds(20, 80, 80, 25);

                    parentName = new JTextField();
                    parentName.setBounds(130, 20, 165, 25);
                    parentLastName = new JTextField();
                    parentLastName.setBounds(130, 50, 165, 25);
                    relationship = new JTextField();
                    relationship.setBounds(130, 80, 165, 25);
                    confirm = new JButton("confirm");
                    confirm.setBounds(150, 110, 100, 25);

                    panel.add(confirm);
                    panel.add(parentName);
                    panel.add(parentLastName);
                    panel.add(relationship);
                    panel.add(label);
                    panel.add(label2);
                    panel.add(label3);
                    panel.revalidate();
                    panel.repaint();
                    confirm();
                } else {
                    try {
                        System.out.println("test");
                        DbFunctions.addPatient(name.getText(), lastname.getText(), pass.getText(), gender.getText(),
                                Integer.parseInt(ssn.getText()), telephone.getText(),
                                birthday.getText(),
                                adresse.getText(), postalCode.getText(),
                                province.getText(), town.getText(), email.getText(), assurance.getText(),
                                branch.getText());
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }
                }
            }
        };
        create.addActionListener(accountCreation);
    }

    public void viewAccount() {
        ActionListener view = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                register();
            }
        };
        infoChange.addActionListener(view);
    }

    public void viewApp() {
        ActionListener appoint = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    panel.removeAll();
                    frame.setLayout(null);
                    frame.setBounds((int) size.getWidth() / 2 - 150, (int) size.getHeight() / 2 - 325, 300, 650);
                    ResultSet apps = DbFunctions.getAppointments(lastName.getText(), name.getText());

                    int y = 30;
                    while (apps.next()) {
                        JLabel a = new JLabel(apps.getString(6) + " " + apps.getString(7) + "-" + apps.getString(8));
                        a.setBounds(20, y, 280, 25);
                        panel.add(a);

                        y = y + 30;
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                panel.revalidate();
                panel.repaint();
            }
        };
        appView.addActionListener(appoint);
    }

    public void confirm() {

        ActionListener conf = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    DbFunctions.addPatient(name.getText(), lastname.getText(), pass.getText(), gender.getText(),
                            Integer.parseInt(ssn.getText()), telephone.getText(),
                            birthday.getText(),
                            adresse.getText(), postalCode.getText(),
                            province.getText(), town.getText(), parentName.getText(), parentLastName.getText(),
                            relationship.getText(),
                            email.getText(),
                            assurance.getText(),
                            branch.getText());
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        confirm.addActionListener(conf);
    }

    public void update() {

        ActionListener conf = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    DbFunctions.modPatient(DbFunctions.getUserid(name.getText(), lastName.getText()),
                            name.getText(),
                            lastname.getText(), gender.getText(),
                            Integer.parseInt(ssn.getText()), telephone.getText(),
                            birthday.getText(),
                            adresse.getText(), postalCode.getText(),
                            province.getText(), town.getText(), parentName.getText(), parentLastName.getText(),
                            relationship.getText(),
                            email.getText(),
                            assurance.getText(),
                            branch.getText());
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        updat.addActionListener(conf);
    }

    public void appointAdd() {
        ActionListener app = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel.removeAll();
                addAppoint();
                panel.revalidate();
                panel.repaint();
            }
        };
        appoint.addActionListener(app);
    }

    public void addApp() {
        ActionListener app = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    DbFunctions.addAppointment(succ.getText(), patientLastName.getText(), patientName.getText(),
                            dentistLastName.getText(),
                            dentistName.getText(),
                            hygLastName.getText(),
                            hygName.getText(), rvdate.getText(), startTime.getText(), endTime.getText(),
                            rvType.getText(),
                            status.getText(), Integer.parseInt(room.getText()), Integer.parseInt(procedure.getText()),
                            Integer.parseInt(procedure.getText()));
                } catch (NumberFormatException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        schedapp.addActionListener(app);

    }

    public void modifyAccount() {
        ActionListener accountCreation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (Integer.parseInt(age.getText()) < 16) {
                    panel.removeAll();
                    frame.setBounds((int) size.getWidth() / 2 - 200, (int) size.getHeight() / 2 - 75, 400, 250);
                    label = new JLabel("parent last name");
                    label.setBounds(20, 20, 120, 25);
                    label2 = new JLabel("parent name");
                    label2.setBounds(20, 50, 80, 25);
                    JLabel label3 = new JLabel("relationship");
                    label3.setBounds(20, 80, 80, 25);

                    parentName = new JTextField();
                    parentName.setBounds(130, 20, 165, 25);
                    parentLastName = new JTextField();
                    parentLastName.setBounds(130, 50, 165, 25);
                    relationship = new JTextField();
                    relationship.setBounds(130, 80, 165, 25);
                    confirm = new JButton("confirm");
                    confirm.setBounds(150, 110, 100, 25);

                    panel.add(confirm);
                    panel.add(parentName);
                    panel.add(parentLastName);
                    panel.add(relationship);
                    panel.add(label);
                    panel.add(label2);
                    panel.add(label3);
                    panel.revalidate();
                    panel.repaint();
                    update();
                } else {
                    try {
                        System.out.println("test");
                        DbFunctions.modPatient(
                                DbFunctions.getUserid(name.getText(), lastName.getText()),
                                name.getText(), lastname.getText(), gender.getText(),
                                Integer.parseInt(ssn.getText()), telephone.getText(),
                                birthday.getText(), adresse.getText(), postalCode.getText(),
                                province.getText(), town.getText(), email.getText(), assurance.getText(),
                                branch.getText());
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }
                }
            }
        };
        create.addActionListener(accountCreation);
    }

}
