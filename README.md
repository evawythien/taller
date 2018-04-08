# Introducción:
Los objetivos que se plantean en la realización de esta práctica son los siguientes:

* Familiarización con la Programación Orientada a Objetos (POO): definición de clases e instancias, uso de la herencia, definición/uso de métodos estáticos y abstractos.
* Realización del diseño orientado a objetos de un problema.
* Implementación de un programa sencillo donde se manejen conceptos relacionados con POO.

La práctica se va a implementar en Java 2 Estándar Edition (J2SE). El compilador de Java que se usará será BlueJ, tal y como se define en el programa de la asignatura.  




# Descripción de la práctica

La práctica del presente curso va a consistir en diseñar e implementar un sistema integrado de gestión de un taller de vehículos. Todos los que somos dueños de algún tipo de vehículo (moto, coche, furgoneta, etc.) tenemos experiencia en llevar el nuestro al taller para algún tipo de revisión y/o reparación. Puede que sea una puesta a punto antes de las vacaciones o algún viaje largo, o debido a un problema concreto o ruido que hace, o alguna fuga de líquido, etc. Hace años, el responsable de un taller no haría más que apuntar en un libro una breve descripción del vehículo, el motivo por el cual ha acudido al taller su dueño y algún número de contacto. Hoy en día, debido en parte a la competición entre talleres y al deseo de aportar servicios de calidad para poder fidelizar al cliente, los talleres usan sistemas de gestión para todo el proceso de recepción, proceso y facturación de cada vehículo que pasa por el taller.

En general, las funciones que tienen un sistema de gestión de un taller de coches son varias:

* Recepción del vehículo: al entrar un vehículo en el taller hay que generar una ficha con los datos (si ya no forma parte del registro histórico del taller) más importantes (marca, modelo, matrícula, cliente, etc.), dejar constancia del motivo de la visita ! 2
(problema mecánico, revisión, etc.) e imprimir el formulario de autorización que el dueño tiene que firmar para autorizar el trabajo.
* Asignación de los trabajos a los mecánicos: a medida que vayan terminando trabajos, el jefe del taller les va asignando nuevos vehículos.
* Proceso de los vehículos: un mecánico, al terminar la reparación de un vehículo, acude al sistema para ver los siguientes trabajos que le tocan. Según la información en el sistema, tiene que investigar el problema, llevar a cabo el trabajo y dejar constancia del proceso en el sistema para que el comercial pueda informar al cliente de que su vehículo está listo para recoger. Una vez que el mecánico termine con un coche, le aparece el siguiente en el que tiene que trabajar. Si por el motivo que sea (por ejemplo, falta de piezas o que un cliente no haya dado su autorización a realizar una reparación debido al coste), un mecánico deja un trabajo en un estado sin completar, anota en el sistema el motivo y pasa al siguiente trabajo.
* Gestión de usuarios: altas, bajas, modificaciones de las personas que figuran en el sistema (miembros del taller [jefe, mecánico, comercial] y clientes). La primera vez que acude un cliente al taller hay que darle de alta en el sistema.
* Gestión de clientes por parte del comercial: comunicar a los clientes el precio de una reparación, informarles de que su vehículo está listo para recoger, presentar ofertas especiales (por ejemplo, revisión antes de la inspección técnica del vehículo [ITV] o puesta a punto para las vacaciones, revisión de los neumáticos, frenos).
4
