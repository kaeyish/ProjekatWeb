<template>
    <div id="sveKnjige">

        Knjige U BAZI:
    <table class="knjige" style="text-align: center;">
      <thead>
        <tr>
          <th>Naslov</th>
          <th>ISBN</th>
          <th>Datum objavljivanja</th>
          <th>Opis</th>
          <th>Ocena</th>
          <th>Autor</th>
          <th>Zanr</th>
          <th>Detalji</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="knjiga of knjige"
            :key="knjiga.id"
            :knjiga="knjiga">
          <td>{{ knjiga.naslov }}</td>
          <td>{{ knjiga.isbn }}</td>
          <td>{{ knjiga.datumObjavljivanja }}</td>
          <td>{{ knjiga.opis }}</td>
          <td>{{ knjiga.ocena }}</td>
          <td>{{ knjiga.autor }}</td>
          <td>{{ knjiga.zanr.naziv }}</td>
          <td> <button class="btn btn-outline-dark" type="button" v-on:click.prevent = "loadKnjigu(knjiga)" >
        Detalji
      </button></td>

        </tr>
      </tbody>
    </table>
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
    table {
    width: auto;
    border-collapse: collapse;
    margin-bottom: 20px;
    text-align: center;
    margin-left: auto;
    margin-right: auto;
  }
  table th,
  table td {
    padding: 8px;
    text-align: center;
    border: 1px solid #000000;
  }
  table th {
    background-color: #5ac5bc;
  }
  table tbody tr:hover {
    background-color: #eed0fc5a;
  }
    </style>