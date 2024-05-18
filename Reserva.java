
    class Reserva {
        private String fecha;
        private int duracion;
        private String habitacion;
        private String buffets;
        private String salon;
    
        public Reserva(String habitacion, String buffets, String salon, int duracion, String fecha) {
            this.habitacion = habitacion;
            this.buffets = buffets;
            this.salon = salon;
            this.duracion = duracion;
            this.fecha = fecha;
        }
    
        public String gethabitacion(){
            return habitacion;
        }
        public void sethabitacion(){
            this.habitacion = habitacion;
        }
        public String getbuffets(){
            return buffets;
        }
        public void setbuffets(){
            this.buffets=buffets;
        }
        public String getsalon(){
            return salon;
        }
        public void setsalon(){
            this.salon = salon;
        }
        public int getduracion(){
            return duracion;
        }
        public void setduracion(){
            this.duracion = duracion;
        }
        public String getfecha(){
            return fecha;
        }
        public void setfecha(){
            this.fecha=fecha;
        }
    
    }

