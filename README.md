# KikoComponentes 🎨

**KikoComponentes** é uma biblioteca de componentes de interface (UI) desenvolvida com **Jetpack Compose** e **Material 3**. O objetivo deste projeto é fornecer uma coleção de componentes altamente personalizáveis, modernos e prontos para uso, seguindo as melhores práticas de desenvolvimento Android.

## 🚀 Tecnologias Utilizadas

*   **Kotlin**: Linguagem principal.
*   **Jetpack Compose**: Toolkit moderno para construção de UI nativa.
*   **Material 3 (Expressive API)**: Uso das versões mais recentes (1.5.0-alpha16) para componentes expressivos e dinâmicos.
*   **Material Icons Extended**: Biblioteca completa de ícones.
*   **Graphics Shapes**: Criação de formas e polígonos dinâmicos.
*   **Navigation Compose**: Gerenciamento de rotas e telas.
*   **Coil**: Carregamento de imagens assíncrono.
*   **Room & DataStore**: Persistência de dados local e preferências.

## 📦 Componentes Disponíveis

A biblioteca conta com uma vasta gama de componentes organizados por categorias:

*   **Alert Dialogs**: Diálogos de confirmação e alerta personalizados (`KikoAlertDialog`).
*   **App Bars**: TopAppBar (Small, Medium, Large, Center) e BottomAppBar.
*   **Badges**: Indicadores de notificação e contadores.
*   **Buttons**: Filled, Outlined, Tonal, Elevated, Split Buttons e Segmented Buttons.
*   **Cards**: Minimal, Elevated, Outlined e Person Cards.
*   **Carousel**: Carrossel de imagens dinâmico (`CarouselKiko`).
*   **Checkbox**: Simples, Multi-seleção e Tri-state (Marcar todos).
*   **Chips**: Assist, Filter, Input e Suggestion Chips.
*   **Date & Time**: DatePickers (Inline, Docked, Modal) e TimePickers.
*   **Dividers**: Divisores horizontais e verticais padronizados.
*   **Lists**: Itens de lista personalizados com suporte a imagens e ações.
*   **Loading & Progress**: Indicadores de progresso circulares, lineares e poligonais expressivos.
*   **Menus**: Dropdown Menus expressivos e Exposed Dropdown Menus (Select).
*   **Navigation**: Barra de navegação inferior personalizada (`NavigationBarKiko`).
*   **Outlined**: Campos de texto personalizados com bordas arredondadas e validação de erro (`KikoOutlinedTextField`).
*   **Radio Buttons**: Seleção única e grupos de botões de rádio.
*   **Search**: Barra de pesquisa customizada com suporte a histórico e limpeza.
*   **Sliders**: Controles deslizantes simples e de intervalo (`SliderKiko`, `RangeSliderKiko`).
*   **Snackbars**: Mensagens rápidas de alerta e confirmação com ações (`SnackBarKiko`).
*   **Switches**: Interruptores personalizados com ícones internos (`SwitchKiko`).
*   **Tabs**: Abas principais e secundárias com indicadores personalizados (`PrimaryTabsKiko`, `SecondaryTabsKiko`).
*   **Tools Bar**: Barra de ferramentas inferior com ações rápidas e FAB (`ToolsBarKiko`).

## 🎨 Tema e Customização

O projeto utiliza um sistema de temas robusto (`KikoComponentesTheme`) que suporta:
*   **Modo Claro e Escuro (Light/Dark Mode)**.
*   **Paletas de Cores Dinâmicas**: Incluindo temas pré-definidos como Padrão, Verde, Vermelho e Roxo.
*   **Padronização**: Todos os componentes são configurados para respeitar as cores `primary`, `secondary` e `tertiary` definidas no tema global.

## 🛠️ Como usar

### Requisitos
*   Android Studio Ladybug ou superior.
*   AGP 9.1.0+
*   Kotlin 2.2.10+

### Instalação
Clone o repositório e importe o módulo `app` como uma biblioteca ou copie os pacotes de componentes necessários para o seu projeto.

```bash
git clone https://github.com/seu-usuario/KikoComponentes.git
```

## 📸 Previews
Todos os componentes possuem suporte a **Compose Previews** no Android Studio, permitindo visualizar as variações de Light e Dark mode em tempo real sem a necessidade de rodar o app em um dispositivo.

---
Desenvolvido com ❤️ por Kiko.
