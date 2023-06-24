<template>
    <div id="sviKorisnici">

        Korisnici U BAZI:

        <!-- <li v-for="user of users"
            :key="user.id"
            :user="user">
             {{ user.ime }} {{ user.prezime }}, {{ user.uloga }}
             <button class="btn btn-outline-dark" type="button" v-on:click.prevent = "loadUser(user)" >Detalji </button>
    </li> -->
    <table class="korisnici" style="text-align: center;">
      <thead>
        <tr>
          <th>Ime</th>
          <th>Prezime</th>
          <th>Korisnicko ime</th>
          <th>Email</th>
          <th>Opis</th>
          <th>Uloga</th>
          <!-- <th>Police</th> -->
          <th>Detalji</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user of users"
            :key="user.id"
            :user="user">
          <td>{{ user.ime }}</td>
          <td>{{ user.prezime }}</td>
          <td>{{ user.korisnickoIme }}</td>
          <td>{{ user.email }}</td>
          <td>{{ user.opis }}</td>
          <td>{{ user.uloga }}</td>
          <!-- <td>{{ user.police }}</td> -->
          <td> <button class="btn btn-outline-dark" type="button" v-on:click.prevent = "loadUser(user)" >Detalji </button></td>

        </tr>
      </tbody>
    </table>
    </div>
  </template>
    
    <script>
    export default{
        name: 'SviKorisnici',   
        data: function() {
            return {
                users: [],
            }
        },
        mounted: function () {
            fetch('http://localhost:9090/api/korisnici')
            .then(response => response.json())
                .then(data => {console.log("Success:", data); this.users = data})
                .catch((error) => {
                    console.error("Error:", error);
                });    
        },
        methods: 
        {
            loadUser(user) {
            this.$router.push('/korisnik/'+user.id);
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