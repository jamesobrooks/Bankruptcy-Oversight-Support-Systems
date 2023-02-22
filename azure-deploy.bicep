resource bossClientDev 'Microsoft.Web/sites@2021-01-15' = {
  name: 'boss-client-dev'
  location: 'global'
  tags: {
    'hidden-related:${resourceGroup().id}/providers/Microsoft.Web/serverfarms/appServicePlan': 'Resource'
  }
  properties: {
    serverFarmId: 'webServerFarms.id'
  }
}