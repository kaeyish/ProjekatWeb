<template>
    <div class="card">
    <div class="card-text">
        
      
      <div class="desc">{{ korisnik.opis }}</div>
    
    
      <table id="police">
            <tr>
              <th>Naziv</th>
              <th>Primarna</th>
            </tr>
            <tr v-for="polica in police" :key="polica.id">
              <td>{{ polica.naziv }}</td>
              <td>{{ polica.primarna }}</td>
              <td>
                <button class="btnSeeMore" v-on:click="seeMore(polica)">
                  See more
                </button>
              </td>
            </tr>
          </table>
    
       </div>
      </div>
     
     
    
    </template>
    
    <script>
    export default{
        name: 'KorisnikVIew',   
        data: function() {
            return {
                korisnik: {},
                police: []
            }
        },
        mounted: function () {
            fetch('http://localhost:9090/api/korisnik/'+ this.$route.params.id)
            .then(response => response.json())
                .then(data => {console.log("Success:", data); this.korisnik = data, this.police=this.korisnik.ostalePolice})
                .catch((error) => {
                    console.error("Error:", error);
                });    
        }
    
    }
    </script>
    