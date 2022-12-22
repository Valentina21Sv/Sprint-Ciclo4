package com.example.sprint2.Entidades;

import java.util.Date;
import java.util.UUID;

public class Producto {
        private String id;
        private String name;
        private String description;
        private int price;
        private String image;
        private boolean eliminate;
        private Date actualization;
        private Date create;
        private String category;

        public Producto(String name, String description, String category, int price, String image) {
                this.id = UUID.randomUUID().toString();
                this.name = name;
                this.description = description;
                this.category = category;
                this.price = price;
                this.image = image;
                this.create = new Date();
                this.actualization = new Date();
                this.eliminate = false;
        }

        public Producto(String name, String description, int price, String image) {
                this.id = UUID.randomUUID().toString();
                this.name = name;
                this.description = description;
                this.price = price;
                this.image = image;
                this.create = new Date();
                this.actualization = new Date();
                this.eliminate = false;
                this.category = category;
        }

        public Producto(String id, String name, String description, String category, int price, String image, Boolean eliminate, Date create, Date actualization) {
                this.id = id;
                this.name = name;
                this.description = description;
                this.category = category;
                this.price = price;
                this.image = image;
                this.create = create;
                this.actualization = actualization;
                this.eliminate = eliminate;

        }


        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public int getPrice() {
                return price;
        }

        public void setPrice(int price) {
                this.price = price;
        }

        public String getImage() {
                return image;
        }

        public void setImage(String image) {
                this.image = image;
        }

        public boolean isEliminate() {
                return eliminate;
        }

        public void setEliminate(boolean eliminate) {
                this.eliminate = eliminate;
        }

        public Date getActualization() {
                return actualization;
        }

        public void setActualization(Date actualization) {
                this.actualization = actualization;
        }

        public Date getCreate() {
                return create;
        }

        public void setCreate(Date create) {
                this.create = create;
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }

}