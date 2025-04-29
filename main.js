2
const valoresMistos = [10, 'texto', true, null, { nome: 'Objeto' }];

for (const valor of valoresMistos) {
  console.log(typeof valor);
}

3
const pessoas = {
  Ana: 25,
  Carlos: 30,
  Maria: 20,
  João: 35
};

for (const nome in pessoas) {
  pessoas[nome] += 1;
}
console.log(pessoas);

4
const objeto = {
  nome: 'Ana',
  idade: 25,
  cidade: 'São Paulo',
  profissao: 'Engenheira'
};

const arrayStrings = [];

for (const chave in objeto) {
  arrayStrings.push(`${chave}: ${objeto[chave]}`);
}

console.log(arrayStrings);

