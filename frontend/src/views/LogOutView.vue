<template>
    <p/>
</template>


<script>
export default{
    name: "LogOutView",
    mounted: function () {
            fetch('http://localhost:9090/api/logout')
            .then(response => response.json())
                .then(data => {console.log("Success:", JSON.stringify(data));})
                .catch((error) => {
                    console.error("Error:", error);
                });    
        }
}
</script>