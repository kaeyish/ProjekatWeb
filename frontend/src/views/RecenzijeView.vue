<template>
    <div id="recenzije">
      Recenzije
      <table>
      <thead>
        <tr>
          <th>Tekst</th>
          <th>Ocena</th>
          <th>Datum</th>
          <th>Autor</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="recenzija in recenzije" :key="recenzija.id">
          <td>{{ recenzija.tekst }}</td>
          <td>{{ recenzija.ocena }}</td>
          <td>{{ recenzija.datum }}</td>
          <td>{{ recenzija.autor }}</td>
        </tr>
      </tbody>
    </table>
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