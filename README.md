<html>
	<head>

<meta charset="UTF-8"/>

</head>
<body>


<h2>REST API em Java</h2>
<hr>



<h3>Requerimentos</h3>
<hr>

<ul>
<li>Necessário Maven</li>
<li>Necessário java versão 1.8.0 acima.</li>
<li>Spring STS caso queira editar e executar pela IDE, (recomendado para fins de editação ou mudanças).</li>
<li>Porta 8064 acessível para poder utilizar caso execute.</li>
<li>Caso utilize internamente o mesmo resgatará o IP interno.</li>
</ul>

<br>

<p>API REST para inserção,extração,atualização e eliminação  de informações <br> de dados de clientes quanto os próprios clientes como,ID,idade e nome, tendo integrado informações de IP de quem requisitou quanto a  <br>resposta que indica não somente informações extraídas do banco de dados mais quanto a informação do clima do local onde o mesmo se localiza.</p>



<h3>Modo de utilização:</h3>
<hr>
<br>
<br>
     git clone https://github.com/h4cker39/restapi-clientes.git
     cd restapi-clientes
     mvn install
<p> Caso esteja utilizando na sua IDE, pode executar via maven ou Spring STS.</p>
<br>
     Após a execução, para fins de testes é necessário inserção de pelo menos um objeto do tipo cliente, o cliente é composto por três dados que são necessários inserir
     <br>
<ul>
     <li>*ID -  tipo String</li>
     <li>*Nome - tipo String</li>
     <li>*Idade - tipo String </li>
</ul>
     Depois da inserção poderá fazer as consultas conforme indicado:
<ul>
<label> Inserção de clientes</label>
<br>
<li>POST /cliente/</li>
<br>
<label>Consulta de cliente via ID.</label>
<br>
<li>GET /cliente/id</li>
<br>
<label> Extrai todas as informações de todos os clientes.</label>
<li> GET /cliente/</li>
<br>
<label> Atualização do cliente</label>
<li>PUT /cliente/</li>
<br>
<label>Apagar o cliente</label>
<br>
<li>DELETE /cliente/id</li>
</ul>


<p>Para fins de teste pode utilizar-se também O POSTMAN, que faz a integração rápida para identação e melhor visualização para requestes, responses em JSON .</p>




<h3>Exemplo</h3>
<hr>
<br>
<br>

    {
        "id": "3003334948847",
        "name": "Joãozinho Da Silva",
        "idade": 28,
        "current_weather": "\"Showers\"",
        "ip": {
            "status": "success",
            "data": {
                "ipv4": "0:0:0:0:0:0:0:1",
                "continent_name": "Oceania",
                "country_name": "Australia",
                "subdivision_1_name": "Victoria",
                "subdivision_2_name": null,
                "city_name": "Research",
                "latitude": "-37.70000",
                "longitude": "145.18330"
            }
        }
    }

<h3>Funcionalidades</h3> 
<hr>
<br>

<ul>
<li>Leveza na transmissão de informações via JSON.</li>
<li>Operações: Inserções,Alterações,Remoção e Consutlas, podendo ser via ID.</li>
</ul>

<br>

<h3>Contribuições</h3>
<hr>
<br>
<h4>
- Issue Tracker: https://github.com/h4cker39/restapi-clientes.git/issues</h4>
<h4>
- Source Code:https://github.com/h4cker39/restapi-clientes.git
</h4>
<br>
<h3>Suporte</h3> 
<hr>
Se tiver alguma informação adcional favor contactar ou algum feedback ou contribuição:

luisgiordano@icloud.com
<br>

<h3>Testes</h3>
<hr>
<p>mvn test ${rest-api}</p>

<br>
<h3>Licença</h3>
<hr>
MIT license 

</body>
</html>
