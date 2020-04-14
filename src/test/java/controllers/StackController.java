package controllers;


import gateways.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Main.Main;
import models.*;

import registry.GatewayRegestry;

import java.io.IOException;

public class StackController {
    @FXML
    TextField MarkOfWeponTF;
    @FXML
    TextField CalibrOfWeponTF;
    @FXML
    TextField AmmoTF;
    @FXML
    TextField NameOfficerTF;
    @FXML
    TextField SNameOfficerTF;
    @FXML
    TextField AgeOfOfficerTF;
    @FXML
    TextField WorkExperience;
    @FXML
    TextField WorkSchedule;
    @FXML
    TextField nameOfClientTF;
    @FXML
    TextField secondnameOfClient;
    @FXML
    TextField ageOfClient;
    @FXML
    RadioButton givenRb;
    @FXML
    RadioButton backedRb;
    @FXML
    RadioButton typeOfVisitOneRB;
    @FXML
    RadioButton typeOfVisitAllRB;
    @FXML
    Pane ClientPanel;
    @FXML
    Pane OfficerPanel;
    @FXML
    Pane WeponPanel;
    @FXML
    Pane ActionPanel;
    @FXML
    TableView<OfficerClientWepon> StatusTabelView;
    @FXML
    TableColumn<OfficerClientWepon, Client> ClientTB;
    @FXML
    TableColumn<OfficerClientWepon, Officer> OfficerTB;
    @FXML
    TableColumn<OfficerClientWepon, Wepon> WeponTB;
    @FXML
    TableColumn<OfficerClientWepon, Action> StatusTB;
    @FXML
    Button clickAddClient;
    @FXML
    Button toWepon;
    @FXML
    Button AddWepon;
    @FXML
    Button clickAddOfficer;
    @FXML
    Button ToListOfAction;
    @FXML
    Button ToOfficer;

    @FXML
    Gateway<Client> clientGateway = new ClientGateway();
    @FXML
    Gateway<Officer> officerGateway = new OfficerGateway();
    @FXML
    Gateway<Wepon> weponGateway = new WeponGateway();
    @FXML
    Gateway<OfficerClientWepon> officerClientWeponGateway = new OfficerClientWeponGateway();
    ObservableList<OfficerClientWepon> officerClientWepons = FXCollections.observableArrayList(officerClientWeponGateway.all());
    Client client;
    Officer officer;
    Wepon wepon;
    Action action;


    public void clickAddWepon() {
        String mark = "";
        Float calibr = null;
        int ammo = 0;
        int flag3 = 0;
        if (MarkOfWeponTF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Mark_Error");
            alert.setContentText("Mark not given");
            alert.showAndWait();
        } else {
            mark = MarkOfWeponTF.getText();
            flag3++;
        }
        if (CalibrOfWeponTF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Calibr_Error");
            alert.setContentText("Calibr not given");
            alert.showAndWait();
        } else {
            calibr = Float.valueOf(CalibrOfWeponTF.getText());
            flag3++;
        }
        if (AmmoTF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Calibr_Error");
            alert.setContentText("Calibr not given");
            alert.showAndWait();
        } else {
            ammo = Integer.parseInt(AmmoTF.getText());
            flag3++;
        }
        if (givenRb.isSelected()) {
            action = Action.getGiving();
        } else if (backedRb.isSelected()) {
            action = Action.getBacking();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Action_Error");
            alert.setContentText("Action not given");
            alert.showAndWait();
        }
        if (flag3 == 3) {
            wepon = new Wepon(mark, calibr, ammo);
            MarkOfWeponTF.clear();
            CalibrOfWeponTF.clear();
            AmmoTF.clear();
            AddWepon.setDisable(true);
            ToListOfAction.isFocused();


        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Add_wepon_Error");
            alert.setContentText("Check all fiends for filling");
            alert.showAndWait();
        }
    }

    public void ClearWepon() {
        MarkOfWeponTF.clear();
        CalibrOfWeponTF.clear();
        AmmoTF.clear();
    }

    public void AddOfficer() {
        String name = "";
        String sName = "";
        Integer age = 0;
        String workExp = "";
        String workSch = "";
        int flag = 0;
        if (NameOfficerTF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Name_Error");
            alert.setContentText("Name not given");
            alert.showAndWait();
        } else {
            name = NameOfficerTF.getText();
            flag++;
        }
        if (SNameOfficerTF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Second_Name_Error");
            alert.setContentText("Second Name not given");
            alert.showAndWait();
        } else {
            sName = SNameOfficerTF.getText();
            flag++;
        }
        if (AgeOfOfficerTF.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Age_Error");
            alert.setContentText("Age not given");
            alert.showAndWait();
        } else {
            age = Integer.valueOf(AgeOfOfficerTF.getText());
            flag++;
        }
        if (WorkExperience.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Work_Experience_Error");
            alert.setContentText("Work Experience not given");
            alert.showAndWait();
        } else {
            workExp = WorkExperience.getText();
            flag++;
        }
        if (WorkSchedule.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Work_Schedule_Error");
            alert.setContentText("Work_Schedule not given");
            alert.showAndWait();
        } else {
            workSch = WorkSchedule.getText();
            flag++;
        }
        if (flag == 5) {
            officer = new Officer(name, sName, age, workExp, workSch);
            NameOfficerTF.clear();
            SNameOfficerTF.clear();
            AgeOfOfficerTF.clear();
            WorkExperience.clear();
            WorkSchedule.clear();
            clickAddOfficer.setDisable(true);
            toWepon.requestFocus();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Add_officer_Error");
            alert.setContentText("Check all fiends for filling");
            alert.showAndWait();
        }


    }


    public void ClearerOfficer() {
        NameOfficerTF.clear();
        SNameOfficerTF.clear();
        AgeOfOfficerTF.clear();
        WorkExperience.clear();
        WorkSchedule.clear();
    }

    public void AddClient() {
        String name = "";
        String sName = "";
        Integer age = 0;
        int flag = 0;
        if (nameOfClientTF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Name_Error");
            alert.setContentText("Name not given");
            alert.showAndWait();
        } else {
            name = nameOfClientTF.getText();
            flag++;
        }
        if (secondnameOfClient.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Second_Name_Error");
            alert.setContentText("Second name not given");
            alert.showAndWait();
        } else {
            sName = secondnameOfClient.getText();
            flag++;
        }
        if (ageOfClient.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Age_Error");
            alert.setContentText("Age not given");
            alert.showAndWait();
        } else {
            age = Integer.valueOf(ageOfClient.getText());
            flag++;
        }
        Boolean type = true;
        if (typeOfVisitOneRB.isSelected()) {
            type = true;
        } else {
            type = false;
        }

        if (flag == 3) {
            client = new Client(name, sName, age, type);
            nameOfClientTF.clear();
            secondnameOfClient.clear();
            ageOfClient.clear();
            clickAddClient.setDisable(true);
            ToOfficer.setDisable(false);
            ToOfficer.requestFocus();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Add_client_Error");
            alert.setContentText("Check all fiends for filling");
            alert.showAndWait();
        }
    }

    public void ClearerClient() {
        clickAddClient.setDisable(true);
        nameOfClientTF.clear();
        secondnameOfClient.clear();
        ageOfClient.clear();
    }

    public void toOfficer() {
        ClientPanel.setVisible(false);
        OfficerPanel.setDisable(false);
        OfficerPanel.setVisible(true);
        ClientPanel.setDisable(true);
        WeponPanel.setVisible(false);
        WeponPanel.setDisable(true);
    }

    public void clickToWepon() {

        ClientPanel.setVisible(false);
        ClientPanel.setDisable(true);

        OfficerPanel.setDisable(true);
        OfficerPanel.setVisible(false);

        WeponPanel.setVisible(true);
        WeponPanel.setDisable(false);

    }

    public void clickToListOfAction() {
        ClientPanel.setVisible(false);
        ClientPanel.setDisable(true);

        OfficerPanel.setDisable(true);
        OfficerPanel.setVisible(false);

        WeponPanel.setVisible(false);
        WeponPanel.setDisable(true);

        ActionPanel.setVisible(true);
        ActionPanel.setDisable(false);
        OfficerClientWepon officerClientWepon = new OfficerClientWepon(officer, client, wepon, action);
        officerClientWepons.add(officerClientWepon);

        /*TODO REWORKED class officerClientWepon*/
    }

    public void clickAddNewNote() {
        ClientPanel.setVisible(true);
        ClientPanel.setDisable(false);

        OfficerPanel.setDisable(true);
        OfficerPanel.setVisible(false);

        WeponPanel.setVisible(false);
        WeponPanel.setDisable(true);

        ActionPanel.setVisible(false);
        ActionPanel.setDisable(true);
        OfficerClientWepon officerClientWepon = new OfficerClientWepon(officer, client,wepon,action);
    }

    public void clickDeleteSelectedNote() {
        int index = StatusTabelView.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            officerClientWepons.remove(index);
            officerClientWeponGateway.delete(index);
        }
    }

    @FXML
    public void initialize() {
        ClientPanel.setVisible(true);
        ClientPanel.setDisable(false);
        OfficerPanel.setDisable(true);
        OfficerPanel.setVisible(false);
        WeponPanel.setVisible(false);
        WeponPanel.setDisable(true);
        ActionPanel.setVisible(false);
        ActionPanel.setDisable(true);
        typeOfVisitOneRB.setSelected(true);
        OfficerTB.setCellValueFactory(item -> item.getValue().officerProperty());
        WeponTB.setCellValueFactory(item -> item.getValue().weponProperty());
        StatusTB.setCellValueFactory(item -> item.getValue().actionProperty());
        StatusTabelView.setItems(officerClientWepons);


        if ((nameOfClientTF.getText().isEmpty()) && (secondnameOfClient.getText().isEmpty()) && (ageOfClient.getText().isEmpty())) {
            ToOfficer.setDisable(true);
            clickAddClient.setDisable(true);
        }
        MarkOfWeponTF.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("[0-9a-zA-Z/-]*")) {
                    MarkOfWeponTF.setText(newValue);
                    AddWepon.setDisable(false);
                } else {
                    MarkOfWeponTF.setText(oldValue);
                    AddWepon.setDisable(true);
                }
            }
        });
        CalibrOfWeponTF.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("[0-9/.]*")) {
                    CalibrOfWeponTF.setText(newValue);
                    AddWepon.setDisable(false);
                } else {
                    CalibrOfWeponTF.setText(oldValue);
                    AddWepon.setDisable(true);
                }
            }
        });
        AmmoTF.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("\\d*")) {
                    AmmoTF.setText(newValue);
                    AddWepon.setDisable(false);
                } else {
                    AmmoTF.setText(oldValue);
                    AddWepon.setDisable(true);
                }
            }
        });
        nameOfClientTF.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("[a-zA-Z/-]*")) {
                    nameOfClientTF.setText(newValue);
                    clickAddClient.setDisable(false);
                } else {
                    nameOfClientTF.setText(oldValue);
                }
            }
        });
        secondnameOfClient.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("[a-zA-Z/-]*")) {
                    secondnameOfClient.setText(newValue);
                    clickAddClient.setDisable(false);
                } else {
                    secondnameOfClient.setText(oldValue);
                }
            }
        });
        NameOfficerTF.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("[a-zA-Z/-]*")) {
                    NameOfficerTF.setText(newValue);
                    clickAddOfficer.setDisable(false);
                } else {
                    NameOfficerTF.setText(oldValue);
                    clickAddClient.setDisable(true);
                }
            }
        });
        SNameOfficerTF.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("^[a-zA-Z/-]*$")) {
                    SNameOfficerTF.setText(newValue);
                    clickAddOfficer.setDisable(false);
                } else {
                    SNameOfficerTF.setText(oldValue);
                    clickAddOfficer.setDisable(true);
                }
            }
        });
        ageOfClient.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("\\d*")) {
                    ageOfClient.setText(newValue);
                    clickAddOfficer.setDisable(false);
                } else {
                    ageOfClient.setText(oldValue);
                    clickAddOfficer.setDisable(true);
                }
            }
        });
        AgeOfOfficerTF.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("\\d*")) {
                    AgeOfOfficerTF.setText(newValue);
                    clickAddOfficer.setDisable(false);
                } else {
                    AgeOfOfficerTF.setText(oldValue);
                    clickAddOfficer.setDisable(true);
                }
            }
        });
        WorkExperience.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("^[0-9-a-zA-Z]*$")) {
                    WorkExperience.setText(newValue);
                    clickAddOfficer.setDisable(false);
                } else {
                    WorkExperience.setText(oldValue);
                    clickAddOfficer.setDisable(true);
                }
            }
        });
        WorkSchedule.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("^[0-9//0-9]*$")) {
                    WorkSchedule.setText(newValue);
                    clickAddOfficer.setDisable(false);
                } else {
                    WorkSchedule.setText(oldValue);
                    clickAddOfficer.setDisable(true);
                }
            }
        });
    }


}