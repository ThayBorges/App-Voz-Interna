# VozInterna - Sistema de Denúncias Internas

## Descrição
VozInterna é um aplicativo Android desenvolvido para gerenciar denúncias internas em empresas, permitindo que funcionários reportem incidentes de forma segura e anônima, e que o RH gerencie e responda essas denúncias.

## Funcionalidades

###  Login e Menu Lateral
- **LoginActivity**: Autenticação com e-mail corporativo
- **Menu Lateral**: Navegação entre todas as telas do app
- Validação de formato de e-mail
- Redirecionamento automático para VisaoActivity após login

###  Visão da Empresa
- **VisaoActivity**: Dashboard com estatísticas de denúncias
- Gráficos e resumos das denúncias
- Menu lateral implementado
- Navegação para outras telas

###  Nova Denúncia
- **NovaDenunciaActivity**: Formulário completo de denúncia
- Campos: tipo, local, hora, descrição, anonimato
- Validação de campos obrigatórios
- Simulação de envio

###  Minhas Denúncias
- **MinhasDenunciasActivity**: Histórico pessoal de denúncias
- RecyclerView com lista de denúncias
- Status: em análise, respondida, encerrada
- Dados simulados para demonstração

###  RH
- **RHActivity**: Gerenciamento de todas as denúncias
- Lista completa com RecyclerView
- Botões de ação: responder, alterar status, visualizar detalhes
- Interface para gestores de RH

## Paleta de Cores
- **Primary**: #05A8AA (Azul)
- **Secondary**: #B8D5B8 (Verde claro)
- **Accent**: #D7B49E (Bege)
- **Warning**: #DC602E (Laranja)
- **Danger**: #BC412B (Vermelho)

## Tecnologias Utilizadas
- **Kotlin** como linguagem principal
- **XML Layouts** para interface do usuário
- **ViewBinding** para binding de views
- **RecyclerView** para listas
- **Navigation Drawer** para menu lateral
- **Material Design** para componentes UI
- **ConstraintLayout** para layouts responsivos

## Estrutura do Projeto
```
app/src/main/
├── java/br/com/thaysa/vozinterna/
│   ├── MainActivity.kt
│   ├── LoginActivity.kt
│   ├── VisaoActivity.kt
│   ├── NovaDenunciaActivity.kt
│   ├── MinhasDenunciasActivity.kt
│   ├── RHActivity.kt
│   ├── Denuncia.kt
│   ├── DenunciaAdapter.kt
│   └── RHAdapter.kt
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   ├── activity_login.xml
│   │   ├── activity_visao.xml
│   │   ├── activity_nova_denuncia.xml
│   │   ├── activity_minhas_denuncias.xml
│   │   ├── activity_rh.xml
│   │   ├── item_denuncia.xml
│   │   ├── item_denuncia_rh.xml
│   │   └── nav_header_main.xml
│   ├── menu/
│   │   └── drawer_menu.xml
│   ├── drawable/
│   │   ├── ic_*.xml (ícones)
│   │   ├── spinner_background.xml
│   │   └── status_background.xml
│   ├── values/
│   │   ├── colors.xml
│   │   ├── strings.xml
│   │   └── themes.xml
│   └── mipmap/ (ícones do app)
```

## Como Executar
1. Clone o repositório
2. Abra o projeto no Android Studio
3. Sincronize o Gradle
4. Execute o app em um emulador ou dispositivo físico

## Fluxo de Navegação
1. **MainActivity** → Redireciona para LoginActivity
2. **LoginActivity** → Valida e-mail e vai para VisaoActivity
3. **VisaoActivity** → Menu lateral para navegar entre telas
4. **NovaDenunciaActivity** → Formulário de nova denúncia
5. **MinhasDenunciasActivity** → Histórico pessoal
6. **RHActivity** → Gerenciamento de denúncias

## Observações
- O app utiliza dados simulados para demonstração
- Não há backend real implementado
- Foco na funcionalidade e interface do usuário
- Design responsivo e seguindo Material Design guidelines

## Desenvolvedores
- **Pedro**: Login e Menu Lateral
- **Luca**: Visão da Empresa
- **Juan**: Nova Denúncia
- **Alessandro**: Minhas Denúncias
- **Thaysa**: RH

## Controle de Versão
- Cada desenvolvedor deve criar uma branch para sua tela
- Nomenclatura: `feature/nome-da-tela`
- Exemplo: `feature/login-activity`, `feature/visao-activity`
