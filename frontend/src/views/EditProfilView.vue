
<template>
    <form name="edit">
        <div class="mb-3">
        <label for="ime">Ime: </label>
        <input id="ime" type="text" v-model="ime" />
      </div>
      <div class="mb-3">
        <label for="prezime">Prezime: </label>
        <input id="prezime" type="text" v-model="prezime" />
      </div>   
      <div class="mb-3">
        <label for="korisnickoIme">Username: </label>
        <input id="korisnickoIme" type="text" v-model="korisnickoIme" />
      </div>
      <div class="mb-3">
        <label for="lozinka">Lozinka: </label>
        <input id="lozinka" type="password" v-model="lozinka" />
      </div>
      <div class="mb-3">
        <label for="potvrdaLozinke">Potvrdite lozinku: </label>
        <input id="potvrdaLozinke" type="password" v-model="potvrdaLozinka" />
      </div>
      <div class="mb-3">
        <label for="opis">Opis: </label>
        <input id="opis" type="text" v-model="opis" />
      </div>
    
      <button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "submit()" >
        Azuriraj me ♥
      </button>
    
        
    </form>
    </template>
    
    <script>
    export default{
        name: 'EditProfil',
        data() {
            return {
                korisnik:{},
                ime:'Buduci',
                prezime: 'Autor',
                korisnickoIme:'ntp309',
                lozinka:'',
                potvrdaLozinka:'',
                opis:'ovo je neki opis ♥'
                //POPOUNITI
        }
        },
        mounted: function () {
            fetch('http://localhost:9090/api/korisnik/'+localStorage.getItem("id"))
            .then(response => response.json())
                .then(data => {console.log("Success:", data); this.korisnik = data})
                .catch((error) => {
                    console.error("Error:", error);
                });    
        },
    methods:{

        submit(){
        const payload = {
                ime:this.ime,
                prezime: this.prezime,
                korisnickoIme:this.korisnickoIme,
                lozinka:this.lozinka,
                opis:this.opis
         };
        fetch('http://localhost:9090/api/korisnik/azuriranje-profila', {
        method: 'POST',
        credentials: 'include',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
      })
      .then((res) => {
          console.log(res);
          if (res.ok) {
            return res.json();
          } else {
           alert("Lose uneti podaci.");
          }
        })
      .then (this.$router.push("/index"))
      // .catch((error)=> {console.error("Error:", error); alert("Greska."); this.$router.push("/index")})
        }
    }

        }
    

    </script>