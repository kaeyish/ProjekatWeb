<template>
    <div id="sviKorisnici">

        Korisnici U BAZI:

        <korisnik-comp v-for="user of users"
            :key="user.id"
            :user="user">
             {{ user.ime }}
        </korisnik-comp>
    </div>
  </template>
    
    <script>
    import KorisnikComp from '@/components/KorisnikComp.vue';
    export default{
        name: 'SviKorisnici',   
        components: {KorisnikComp}, 
        data: function() {
            return {
                users: [],
            }
        },
        mounted: function () {
            fetch('http://localhost:9090/api/korisnici')
            .then(response => response.json())
                .then(data => {console.log("Success:", data); this.knjige = data})
                .catch((error) => {
                    console.error("Error:", error);
                });    
        },
    
    }
    </script>
    
    <style>
    
    </style>