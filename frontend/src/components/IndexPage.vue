<template>
    <div class="index">
        <img alt="Site logo" id="logo" src="../assets/old-open-Book-Clip-Art.png">
        <h1>{{ msg }}</h1>
      <p>
        </p>
  
  
  
  
    </div>
  </template>
  
  <script>
  export default {
    name: 'IndexPage',
    props: {
    msg: String
  }
  }
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  h3 {
    margin: 40px 0 0;
  }
  ul {
    list-style-type: none;
    padding: 0;
  }
  li {
    display: inline-block;
    margin: 0 10px;
  }
  a {
    color: #c9b38d;
  }

  h1 {
    color: #c9b38d;
  }

  #logo {
        max-width:200pt !important;
  }
  </style>
  