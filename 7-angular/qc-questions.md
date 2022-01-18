# ⁉️ Week 7: Angular QC Questions ⁉️
> *These will be asked in QC on the week of Jan. 24th*

1.  What makes a “single page application” (SPA) different from a normal web page?
    
2.  Explain the difference between server-side and client-side rendering
    
3.  What are some features of the Angular framework?
    
4.  How does TypeScript relate to JavaScript? What are the major benefits of using it over JavaScript?
    
5.  List the data types of TypeScript
    
6.  How would you create a new Angular project?
    
7.  What is a component? How would you create one? List some other commands using the Angular CLI
    
8.  What files make up a component? What is the “spec” file used for?
    
9.  Explain the relevance of npm to Angular projects. Which file does npm use to track dependencies?
    
10.  List some decorators for Angular apps

    - Class decorators, e.g. @Component and @NgModule
    - Property decorators for properties inside classes, e.g. @Input and @Output
    - Method decorators for methods inside classes, e.g. @HostListener
    - Parameter decorators for parameters inside class constructors, e.g. @Inject
    
11.  What is the lifecycle of a component? List some lifecycle hooks:

    - There are 8 different stages in the component lifecycle. 
    - Every stage is called as lifecycle hook event. So, we can use these hook events in different phases of our application to obtain control of the components.
    - LiefeCycleHooks include: ngOnInit, ngOnDestroy, ngDoChecks(), ngAfterViewInit()
    
12.  What is a directive and what are the different types? How to tell these directives apart with syntax?
    
13.  What is the benefit of using a directive like NgClass over the class attribute, or even property binding to the class attribute?
    
14.  What is a pipe? A service?
    
15.  How would you create a custom pipe? What about a service?
    
16.  How does dependency injection work in Angular?
    
17.  What is an Angular module? What properties should you set inside it?
    
18.  What’s the difference between a JavaScript module and Angular module? What are some common Angular modules?

- An NgModule is a class marked by the @NgModule decorator with a metadata object that describes how that particular part of the app fits together with the other parts. NgModules are specific to Angular. While classes with an @NgModule decorator are by convention kept in their own files, they differ from JavaScript modules because they include this metadata.
- [NG Module vs. JS Module](https://angular.io/guide/ngmodule-vs-jsmodule)
    
19.  How would you run your unit tests for an Angular project?
    
20.  How have you used the HttpClient? What methods does it have and what do they return?
    
21.  What is an Observable? What’s the difference between it and a Promise?

    > Promises deal with **one** asynchronous event at a time, while observables handle a **sequence** of asynchronous events over a period of time.
    
22.  What forms of data binding does Angular support? Explain the syntax for each
    
23.  What does Webpack do for your ng project?

- Webpack is a tool that lets you compile JavaScript modules, also known as module bundler. Given a large number of files, it generates a single file (or a few files) that run your app. It can perform many operations: helps you bundle your resources
    
24.  How would you implement routing in your project?
    

<hr> 