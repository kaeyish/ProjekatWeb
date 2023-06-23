<template>
    <div id="sveKnjige">

        KNJIGE U BAZI:

        <li v-for="korisnik in korisnici"
            :key="korisnik.id"
            :korisnik="korisnik">
            {{ korisnik.ime }}
    </li>
    </div>
  </template>
    
    <script>
    export default{
        name: 'KorisniciView',   
        data: function() {
            return {
                korisnici: [],
            }
        },
        mounted: function () {
            fetch('http://localhost:9090/api/korisnici')
            .then(response => response.json())
                .then(data => {console.log("Success:", data); this.knjige = data})
                .catch((error) => {
                    console.error("Error:", error);
                });    
        }
    
    }
    </script>
    
    <style>
    
    </style>