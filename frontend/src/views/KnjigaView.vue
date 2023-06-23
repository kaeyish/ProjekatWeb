<template>
  
    <div id="knjiga">
  <!-- <img src={{ knjiga.naslovnaFotografija }}> -->
  {{ knjiga.naslov }}
  <p/>
   {{ knjiga.isbn }}
   <p/>
   <button class="btn btn-outline-dark" type="button" v-on:click.prevent = "getRecenzije(knjiga.id)">Izlistaj recenzije knjige </button>
    </div>
  </template>
  
  <script>
  export default{
      name: 'KnjigaView',   
      data: function() {
          return {
              knjiga: {},
              recenzije:[]
          }
      },
      mounted: function () {
          fetch('http://localhost:9090/api/knjiga/'+ this.$route.params.id)
          .then(response => response.json())
              .then(data => {console.log("Success:", data); this.knjiga = data})
              .catch((error) => {
                  console.error("Error:", error);
              });    
      },
      methods:{
          getRecenzije(id){
              fetch('http://localhost:9090/api/recenzija-knjige/' + id)
              .then(response => response.json())
              .then(data => {if (data.status===200)console.log("Success:", data); else { var alertStr = "Error " + data.status +" " + data.error; alert(alertStr); console.log(data)} this.recenzije = data})
              .catch((error) => {
                  console.error("Error:", error);
              });    
          }

      }
  }
  </script>
  
  <style>
  </style>