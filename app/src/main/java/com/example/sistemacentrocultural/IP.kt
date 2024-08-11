package com.example.sistemacentrocultural

class IP {
        var id:Int=0
        var IP:String=""

        constructor(IP:String){
            this.IP=IP
        }
        //sobre carga de mètodos
        constructor(id:Int,IP:String){
            this.IP=IP
            this.id=id
        }
        constructor(){
        }
    }
