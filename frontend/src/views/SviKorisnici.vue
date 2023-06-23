<template>
    <div id="sviKorisnici">

        Korisnici U BAZI:

        <li v-for="user of users"
            :key="user.id"
            :user="user">
             {{ user.ime }} {{ user.prezime }}, {{ user.uloga }}
             <button class="btn btn-outline-dark" type="button" v-on:click.prevent = "loadUser(user)" >Detalji </button>
    </li>
    </div>
  </template>
    
    <script>
    export default{
        name: 'SviKorisnici',   
        data: function() {
            return {
                users: [],
            }
        },
        mounted: function () {
            fetch('http://localhost:9090/api/korisnici')
            .then(response => response.json())
                .then(data => {console.log("Success:", data); this.users = data})
                .catch((error) => {
                    console.error("Error:", error);
                });    
        },
        methods: 
        {
            loadUser(user) {
            this.$router.push('/korisnik/'+user.id);
        }
      }
    }
    
    </script>
    
    <style>
    
    </style>