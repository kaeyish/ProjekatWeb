<template>
  <div id="zanrovi">
    ZANROVI
      <table class="zanr">
      <thead>
        <tr>
          <th>Naziv</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="zanr of zanrovi"
            :key="zanr.id"
            :zanr="zanr">
          <td>{{ zanr.naziv }}</td>
        </tr>
      </tbody>
    </table>
    </div>
</template>

<script>
export default {
    name: 'SviZanrovi',
    data: function() {
            return {
                zanrovi: [],
            }
        },
        mounted: function () {
            fetch('http://localhost:9090/api/zanrovi')
            .then(response => response.json())
                .then(data => {console.log("Success:", data); this.zanrovi = data})
                .catch((error) => {
                    console.error("Error:", error);
                }); 
            },
            methods: 
        {
            loadZanr(zanr) {
            this.$router.push('/zanr/'+zanr.id);
        }
      }  
}
</script>

<style>
  .zanr {
  width: 50%;
  border-collapse: collapse;
  margin-bottom: 10px;
  text-align: center;
}
.zanr th,
.zanr td {
  padding: 7px;
  text-align: center;
  border: 1px solid #000000;
}
.zanr th {
  background-color: #9cf4eb;
}
.zanr tbody tr:hover {
  background-color: #eed0fc5a;
}
</style>