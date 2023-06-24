<template>
    <div id="recenzije">
      Recenzije
      <li v-for="recenzija of recenzije"
              :key="recenzija.id"
              :recenzija="recenzija">
               {{ recenzija.tekst }}
      </li>
    </div>
  </template>
  
  <script>
  export default {
      name: 'SveRecenzije',
      data: function() {
              return {
                  recenzije: [],
              }
          },
          mounted: function () {
              fetch('http://localhost:9090/recenzije')
              .then(response => response.json())
                  .then(data => {console.log("Success:", data); this.recenzije = data})
                  .catch((error) => {
                      console.error("Error:", error);
                  }); 
              },
              methods: 
          {
              loadZanr(recenzija) {
              this.$router.push('/recenzija/'+recenzija.id);
          }
        }  
  }
  </script>
  
  <style>
  
  </style>