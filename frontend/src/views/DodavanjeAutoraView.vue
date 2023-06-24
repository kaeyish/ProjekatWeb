
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
      name: 'DodavanjeKorisnika',
      data() {
          return {
              ime:'',
              prezime: '',
              opis:''
              //POPOUNITI
      }
      },  
  methods:{

      submit(){
      const payload = {
              ime:this.ime,
              prezime: this.prezime,
              opis:this.opis
       };
      fetch('http://localhost:9090/api/korisnik/save', {
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