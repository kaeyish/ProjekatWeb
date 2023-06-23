<template>
    <div id="sveKnjige">

        Knjige U BAZI:

        <li v-for="knjiga of knjige"
            :key="knjiga.id"
            :knjiga="knjiga">
             {{ knjiga.naslov }} {{ knjiga.isbn }}
        <button class="btn btn-outline-dark" type="button" v-on:click.prevent = "loadKnjigu(knjiga)" >
        Detalji
      </button> 
    </li>
    </div>
  </template>
    
    <script>
    export default{
        name: 'SveKnjige',   
        data: function() {
            return {
                knjige: [],
            }
        },
        mounted: function () {
            fetch('http://localhost:9090/api/knjige')
            .then(response => response.json())
                .then(data => {console.log("Success:", data); this.knjige = data})
                .catch((error) => {
                    console.error("Error:", error);
                });    
        },
        methods: 
        {
            loadKnjigu(knjiga) {
            this.$router.push('/knjige/'+knjiga.id);
        }
      }
    }
    
    </script>
    
    <style>
    
    </style>