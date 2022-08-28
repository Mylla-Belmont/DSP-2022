## LISTA 02

1. Crie uma aplicação Java para receber via argumento de linha de comando um nome de arquivo texto e uma string S. A aplicação deve exibir todas as linhas que tenham S como substring, independente dos caracteres estarem em caixa alta ou baixa (case-insensitive).

2. Escreva uma aplicação Java para receber via argumentos de linha de comando três nomes de arquivos. Deve-se gerar um novo arquivo a partir da concatenação dos dois primeiros arquivos. O nome do novo arquivo gerado é o último dos três nomes de arquivos recebidos como entrada.

3. Escolha e baixe um arquivo csv de no mínimo 1 MB, a partir da plataforma Kaggle (https://www.kaggle.com/datasets) e use-o nas questões a seguir. Na resolução desta questão, não enviar os arquivos envolvidos, mas somente os resultados pedidos em arquivo PDF. Envie somente o link do arquivo escolhido.

    Gere as somas checksum, md5 e sha1 do arquivo usando utilitários de linha de comando do próprio sistema operacional ou instalado nele.
    Compacte via linha de comando o arquivo csv original usando compressões zip, gzip e rar. Depois disso compare os tempos e tamanhos dos arquivos gerados. Dica: para obter o tempo de execução, use o comando time.
        Exemplo: time zip iris.zip iris.csv

4. Escreva um arquivo de propriedades Java via editor de textos. Esse arquivo deve ter os dados de chave e valor. Exemplo:

    arquivo config.properties
        arquivo = meu_arquivo.txt
        linha_inicial = 1
        linha_final = 3

    Depois, escreva uma classe Java que exibe da linha_inicial até a linha_final do arquivo, conforme definidos no arquivo de propriedades config.properties.
