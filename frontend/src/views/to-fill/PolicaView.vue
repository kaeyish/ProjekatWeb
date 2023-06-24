<template>
    <div class="polica">
    
        <h1>{{ polica.naziv }}</h1>

      <table id="polica">
            <tr>
              <th>Stavke</th>
            </tr>
            <tr v-for="stavka in stavkePolice" :key="stavka.id">
              <td>{{ stavka.knjiga.naslov }}</td>
              <td>{{ stavka.recenzija.id }}</td>
              <td>
                <button class="btnSeeMore" v-on:click="seeMore(stavka)">
                  See more
                </button>
              </td>
            </tr>
          </table>
    
       </div>
     
     
    
    </template>
    
    <script>
    export default{
        name: 'PolicaView',   
        data: function() {
            return {
                polica: {},
                stavkePolice: []
            }
        },
        mounted: function () {
            fetch('http://localhost:9090/api/police/'+ this.$route.params.id)
            .then(response => response.json())
                .then(data => {console.log("Success:", data); this.polica = data, this.stavkePolice=this.polica.stavkePolice})
                .catch((error) => {
                    console.error("Error:", error);
                });    
        },
        methods:{
            seeMore(stavka){
              this.$router.push("/stavke"+stavka.id)
            }
        }
    
    }
    </script>
    