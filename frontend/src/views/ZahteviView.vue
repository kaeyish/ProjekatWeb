<template>

<table id="polica">
            <tr>
              <th>Email</th>
              <th>Telefon</th>
              <th>Status</th>
              <th>Poruka</th>
              <th>Autor</th>
              <th>Datum</th>
            </tr>
            <tr v-for="zahtev in zahtevi" :key="zahtev.id" :zahtev="zahtev">
                <td>{{ zahtev.email }}</td>
                <td>{{ zahtev.telefon }}</td>
                <td>{{ zahtev.status }}</td>
                <td>{{ zahtev.poruka }}</td>
                <td>{{ zahtev.autor }}</td>
                <td>{{ zahtev.datum }}</td>
                <td>
                <button class="btnSeeMore" v-on:click="prihvati(zahtev.id)">
                  Prihvati
                </button>
              </td><td>
                <button class="btnSeeMore" v-on:click="odbij(zahtev.id)">
                  Odbij
                </button>
              </td>
            </tr>
          </table>
    
        
</template>
    
    <script>
    export default{
        name: 'ZahteviView',   
        data: function() {
            return {
                zahtevi: [],
            }
        },
        mounted: function () {
          if (localStorage.getItem("user") == null){
                alert("Niste ulogovani");
                this.$router.push("/index");
            }
            else if(localStorage.getItem("uloga")=="ADMINISTRATOR"){
                alert("Ovoj stranici moze pristupiti samo admin");

                this.$router.push("/index");
            }
            else {fetch('http://localhost:9090/api/zahtevi')
            .then(response => response.json())
                .then(data => {console.log("Success:", data); this.zahtevi = data})
                .catch((error) => {
                    console.error("Error:", error);
                }); }   
        },
        methods:{
          prihvati(id){
            fetch('http://localhost:9090/api/odobri-zahtev/'+id, {
        method: 'PUT',
        credentials: 'include',
        headers: {
          'Content-Type': 'application/json'
        },
      })
      .then (this.$router.push("/index"));

          },
          odbij(id){     
            fetch('http://localhost:9090/api/odbij-zahtev/'+id, {
        method: 'PUT',
        credentials: 'include',
        headers: {
          'Content-Type': 'application/json'
        },
      })
      .then (this.$router.push("/index"));


          }
        }
    
    }
    </script>
    <style>
    </style>