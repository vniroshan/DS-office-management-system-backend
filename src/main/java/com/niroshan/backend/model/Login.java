package com.niroshan.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Login {

        @Id
        @Column(name = "email")
        private String email;

        @Column(name = "password")
        private String password;

        public Login(){

        }

        public class login {
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public Login(String email, String password) {
            this.password = password;
            this.email = email;
        }
}
