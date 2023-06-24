<template>
    <div>
      <input type="text" v-model="searchQuery" placeholder="Unesite naziv knjige" />
      <button @click="searchBooks">Pretraga</button>
  
      <ul>
        <li v-for="knjiga in knjige" :key="knjiga.id">
          {{ knjiga.naslov }}
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        searchQuery: '',
        knjige: [],
      };
    },
    methods: {
      searchBooks() {
        fetch('http://localhost:9090/api/knjige/${this.searchQuery}}')
          .then(response => response.json())
          .then(data => {
            this.knjige = data;
          })
          .catch(error => {
            console.error(error);
          });
      },
    },
  };
  </script>
  