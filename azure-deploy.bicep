param location string

resource bossClientDev 'Microsoft.Web/sites@2021-01-15' = {
  name: 'boss-client-dev'
  location: location
  tags: {
    'hidden-related:${resourceGroup().id}/providers/Microsoft.Web/serverfarms/appServicePlan': 'Resource'
  }
  properties: {
    serverFarmId: 'webServerFarms.id'
  }
}