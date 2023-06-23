<template>
    <tr>
      <td>{{ korisnik.ime }}</td>
      <td>{{ korisnik.prezime }}</td>
      <td>{{ korisnik.uloga }}</td>
      <td>
        <button class="btnSeeMore" v-on:click="seeMore">See more</button>
      </td>
      <td>
        <button class="delete" v-on:click="deleteEmployee">
          Delete
        </button>
      </td>
    </tr>
  </template>
  
  <script>
  export default {
    name: "KOrisnikComp",
    props: ["korisnik"],
    methods: {
      seeMore: function () {
        this.$router.push("/korisnik/" + this.korisnik.id);
      },
      deleteEmployee: function() {
        fetch("http://localhost:9090/api/korisnik/delete/" + this.employee.id, {
          method: "DELETE",
        }).then((res) => {
          if (res.ok) {
            window.location.reload();
          }
        });
      },
    },
  };
  </script>
  
  
  <style>
  </style>
  