<template>
    <div class="card">
    <div class="card-text">
        <div class="portada">
    
            <!-- <img src={{korisnik.profilnaSlika}} /> -->
        </div>
        <div class="title-total">   
          <div class="title">{{korisnik.uloga}}</div>
          <h2>{{korisnik.ime}} {{korisnik.prezime}}</h2>
          <h6>datum rodjenja nije najfunkcionalniji: {{ korisnik.datumRodjenja }}</h6>
          <p/>
       
        
      
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
          <button class="btnAddPolica" v-on:click="redirect(korisnik)">
                  Dodaj Policu
                </button>
       </div>
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
        },
        methods:{
          seeMore(polica){
            this.$router.push("/polica/"+polica.id);
          },
          redirect(korisnik){
            this.$router.push("/dodaj-policu/"+korisnik.id);
          }
        }
    
    }
    </script>
    
    <style>

    </style>