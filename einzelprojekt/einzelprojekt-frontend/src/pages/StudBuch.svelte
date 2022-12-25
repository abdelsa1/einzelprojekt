<script>
import axios from "axios";
import { isAuthenticated, user, jwt_token } from "../store";
    // TODO: Setze hier die URL zu deinem mit Postman erstellten Mock Server
    const api_root = "http://localhost:8080";

    let buch = [];
    let buecher = {
        isbn: null,
        titel: null,
        autor: null,
        kategorie: null,
        buchState: null,
    };

    let buecherState = {
        buchId: null,
        studierendeId: null,
    }

    function getBuchbyState() {
        var config = {
            method: "get",
            url: api_root + "/api/buch",
            headers: {Authorization: "Bearer " + $jwt_token,}

};
        

        axios(config)
            .then(function (response) {
                buch = response.data;
            })
            .catch(function (error) {
                alert("Could not get buch");
                console.log(error);
            });
    }
    getBuchbyState();

 function AssignBuch() {
        var config = {
            method: "post",
            url: api_root + "/api/service/buchassignment",
            headers: {"Content-Type": "application/json",
            Authorization: "Bearer " + $jwt_token,
            },
            data: buecherState,
        };

        axios(config)
            .then(function (response) {
                alert("Buch reserviert");
                AssignBuch();
            })
            .catch(function (error) {
                alert("Reservation fehlgeschlagen");
                console.log(error);
            });
    }


</script>



<h2>Alle Bücher</h2>
  <br>
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-bs-toggle="tab" href="#verfuegbar">Verfügbar</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="#reserviert">Reserviert</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="ausgeliehen">Ausgeliehen</a>
    </li>
  </ul>

  <!-- Kachel -->
  <div class="tab-content">
    <div id="verfuegbar" class="container tab-pane active"><br>
      <table class="table">
    <thead>
        <tr>
            <th scope="col">ISBN</th>
            <th scope="col">Buchtitel</th>
            <th scope="col">AutorIn</th>
            <th scope="col">Kategorie</th>
            <th scope="col">Status</th>
            <th scope="col">Buch reservieren</th> 


        </tr>
    </thead>
    <tbody>
        {#each buch as b}
        {#if b.buchState === 'VERFUEGBAR'}
            <tr>
                <td>{b.isbn}</td>
                <td>{b.titel}</td>
                <td>{b.autor}</td>
                <td>{b.kategorie}</td>
                <td>{b.buchState}</td>             
                <button type="button" class="btn btn-outline-success" on:click={AssignBuch}>Reservieren</button>


            </tr>
            {/if}
        {/each}
        
    </tbody>
</table>
    </div>
    

  <!-- Kachel -->
    <div id="reserviert" class="container tab-pane fade"><br>
       <table class="table">
    <thead>
        <tr>
            <th scope="col">ISBN</th>
            <th scope="col">Buchtitel</th>
            <th scope="col">AutorIn</th>
            <th scope="col">Kategorie</th>
            <th scope="col">Status</th>


        </tr>
    </thead>
    <tbody>
        {#each buch as b}
             {#if b.buchState === 'RESERVIERT'}
            <tr>
                <td>{b.isbn}</td>
                <td>{b.titel}</td>
                <td>{b.autor}</td>
                <td>{b.kategorie}</td>
                <td>{b.buchState}</td>
            </tr>
            {/if}
        {/each}
    </tbody>
</table>
  </div>

<!-- Kachel -->
    <div id="ausgeliehen" class="container tab-pane fade"><br>
       <table class="table">
    <thead>
        <tr>
            <th scope="col">ISBN</th>
            <th scope="col">Buchtitel</th>
            <th scope="col">AutorIn</th>
            <th scope="col">Kategorie</th>
            <th scope="col">Status</th>

        </tr>
    </thead>
    <tbody>
        {#each buch as b}
             {#if b.buchState === 'AUSGELIEHEN'}
            <tr>
                <td>{b.isbn}</td>
                <td>{b.titel}</td>
                <td>{b.autor}</td>
                <td>{b.kategorie}</td>
                <td>{b.buchState}</td>
            </tr>
            {/if}
        {/each}
    </tbody>
  </div>


  </div>
