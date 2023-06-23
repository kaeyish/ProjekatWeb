<template>
    <div id="sveKnjige">

        KNJIGE U BAZI:

        <li v-for="knjiga in knjige"
            :key="knjiga.id"
            :knjiga="knjiga">
            {{ knjiga.ime }}
    </li>
    </div>
  </template>
    
    <script>
    export default{
        name: 'KnjigeVIew',   
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
        }
    
    }
    </script>
    
    <style>
    
    </style>