export const APP_MENU: AppMenuItem[] = [

  {
    name: 'Home',
    description: 'Home page',
    icon: 'public',
    link: ['']
  },
  {
    name: 'com.michackathon.entity.Flight Search',
    description: 'com.michackathon.entity.Flight Search page',
    icon: 'casino',
    link: ['flightsearch'],
    roles: ['ROLE_ADMIN']
  },
  // {
  //   name: 'Crud',
  //   description: 'Simple crud',
  //   icon: 'edit',
  //   link: ['crud'],
  //   roles: ['ROLE_ADMIN']
  // },
  {
    name: 'About',
    description: 'About page',
    icon: 'person',
    link: ['about']
  }
];

export interface AppMenuItem {
  name: string;
  description: string;
  icon: string;
  link: string[];
  roles?: string[];
}
